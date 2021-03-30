package testClases;

import Utils.ReadProperties;
import page.CargaInformacion;
import page.Index;
import page.MatrizInformacion;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnviarEmail {


    public void sendEmail(){
        String usuario= ReadProperties.readFromConfig("propiedades.properties").getProperty("usuario");
        String key = ReadProperties.readFromConfig("propiedades.properties").getProperty("key");
        String texto= ReadProperties.readFromConfig("propiedades.properties").getProperty("texto");
        String email=ReadProperties.readFromConfig("propiedades.properties").getProperty("email");
        String area=ReadProperties.readFromConfig("propiedades.properties").getProperty("area");
        String fecha=ReadProperties.readFromConfig("propiedades.properties").getProperty("fecha");
        String lista= ReadProperties.readFromConfig("propiedades.properties").getProperty("lista");
        boolean sMultiple0 = Boolean.parseBoolean(ReadProperties.readFromConfig("propiedades.properties").getProperty("sMultiple0"));
        boolean sMultiple1 = Boolean.parseBoolean(ReadProperties.readFromConfig("propiedades.properties").getProperty("sMultiple1"));
        boolean sMultiple2 = Boolean.parseBoolean(ReadProperties.readFromConfig("propiedades.properties").getProperty("sMultiple2"));
        String rButton = ReadProperties.readFromConfig("propiedades.properties").getProperty("rButton");
        Index index = new Index();
        index.inicio(usuario,key);
        CargaInformacion cargaInformacion = new CargaInformacion();
        cargaInformacion.llenarCampos(texto,email,area,lista,sMultiple0,sMultiple1,sMultiple2,rButton);
        cargaInformacion.llenarCampos2(fecha);
        cargaInformacion.enviar();

        MatrizInformacion matrizInformacion = new MatrizInformacion();
        String mensaje=matrizInformacion.bucarInformacion(ReadProperties.readFromConfig("propiedades.properties").getProperty("filtro"));


        Properties properties = new Properties();
        Session session;
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.port",587);
        properties.put("mail.smtp.auth", "true");

        session = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(session);
        try{

            message.setFrom(new InternetAddress(ReadProperties.readFromConfig("propiedades.properties").getProperty("correo")));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(ReadProperties.readFromConfig("propiedades.properties").getProperty("correoRecibe")));
            message.setSubject("Prueba");
            message.setText(mensaje);

            Transport transporte = session.getTransport("smtp");
            transporte.connect(ReadProperties.readFromConfig("propiedades.properties").getProperty("correo"), ReadProperties.readFromConfig("propiedades.properties").getProperty("clave"));
            transporte.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            transporte.close();
        }catch (MessagingException me){
            System.out.println("Correo no enviado");

        }

    }
}
