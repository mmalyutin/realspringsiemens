package never_use_switch_lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

/**
 * @author Evgeny Borisov
 */
@Service
public class MailSender {


    private Map<Integer, MailGenerator> map = new HashMap<>();



    public void sendMail(MailInfo mailInfo) {
        int mailType = mailInfo.getMailType();
        MailGenerator mailGenerator = map.get(mailType);
        if (mailGenerator == null) {
            throw new UnsupportedOperationException(mailType + " not supported yet");
        }
        String html = mailGenerator.generate(mailInfo);
        send(html);
    }

    private void send(String html) {
        System.out.println("html = " + html);
    }

    public void registerBean(int mailType, MailGenerator mailGenerator) {
        map.put(mailType, mailGenerator);
    }
}





