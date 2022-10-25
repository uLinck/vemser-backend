package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailService {

    private final freemarker.template.Configuration fmConfiguration;

    @Value("${spring.mail.username}")
    private String from;

    private static final String TO = "gustavo.ferreira@dbccompany.com.br";

    private final JavaMailSender emailSender;

    public void sendSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(TO);
        message.setSubject("Assunto");
        message.setText("Teste \n minha mensagem \n\nAtt,\nSistema.");
        emailSender.send(message);
    }

    public void sendWithAttachment() throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message,
                true);

        helper.setFrom(from);
        helper.setTo(TO);
        helper.setSubject("Subject");
        helper.setText("Teste\n minha mensagem \n\nAtt,\nSistema.");

        File file1 = new File("imagem.jpg");
        FileSystemResource file
                = new FileSystemResource(file1);
        helper.addAttachment(file1.getName(), file);

        emailSender.send(message);
    }

    public void sendCreateEmail(Pessoa pessoa) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoa.getEmail());
            mimeMessageHelper.setSubject("Usuário criado");
            mimeMessageHelper.setText(createByTemplate(pessoa.getIdPessoa(), pessoa.getNome()), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    public void sendUpdateEmail(PessoaDTO pessoa) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoa.getEmail());
            mimeMessageHelper.setSubject("Usuário atualizado");
            mimeMessageHelper.setText(updateByTemplate(pessoa.getNome()), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    public void sendRemoveEmail(PessoaDTO pessoa) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoa.getEmail());
            mimeMessageHelper.setSubject("Usuário removido");
            mimeMessageHelper.setText(removeByTemplate(pessoa.getNome()), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    public String createByTemplate(Integer idPessoa, String nomePessoa) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", nomePessoa);
        dados.put("id", idPessoa);
        dados.put("email", from);
        Template template = fmConfiguration.getTemplate("endereco-email-template-create.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public String updateByTemplate(String nomePessoa) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", nomePessoa);
        dados.put("email", from);
        Template template = fmConfiguration.getTemplate("email-template-update.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public String removeByTemplate(String nomePessoa) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", nomePessoa);
        dados.put("email", from);
        Template template = fmConfiguration.getTemplate("email-template-remove.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public void sendCreateEnderecoEmail(PessoaDTO pessoa, Endereco endereco) {

        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoa.getEmail());
            mimeMessageHelper.setSubject("Endereço criado");
            mimeMessageHelper.setText(enderecoCreateByTemplate(pessoa.getNome(), endereco.getIdEndereco()), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    public void sendUpdateEnderecoEmail(PessoaDTO pessoa, Endereco endereco) {

        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoa.getEmail());
            mimeMessageHelper.setSubject("Endereço atualizado");
            mimeMessageHelper.setText(enderecoUpdateByTemplate(pessoa.getNome(), endereco.getIdEndereco()), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    public void sendRemoveEnderecoEmail(PessoaDTO pessoa, Endereco endereco) {

        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoa.getEmail());
            mimeMessageHelper.setSubject("Endereço deletado");
            mimeMessageHelper.setText(enderecoRemoveByTemplate(pessoa.getNome(), endereco.getIdEndereco()), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    public String enderecoCreateByTemplate(String nomePessoa, Integer endereco) throws IOException, TemplateException {

        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", nomePessoa);
        dados.put("email", from);
        dados.put("idEndereco", endereco);
        Template template = fmConfiguration.getTemplate("endereco-email-template-create.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;

    }

    public String enderecoUpdateByTemplate(String nomePessoa, Integer endereco) throws IOException, TemplateException {

        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", nomePessoa);
        dados.put("email", from);
        dados.put("idEndereco", endereco);
        Template template = fmConfiguration.getTemplate("endereco-email-template-update.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;

    }

        public String enderecoRemoveByTemplate(String nomePessoa, Integer endereco) throws IOException, TemplateException {

            Map<String, Object> dados = new HashMap<>();
            dados.put("nome", nomePessoa);
            dados.put("email", from);
            dados.put("idEndereco", endereco);
            Template template = fmConfiguration.getTemplate("endereco-email-template-remove.ftl");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
            return html;

        }

}


