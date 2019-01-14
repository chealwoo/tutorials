package cwl.net.sync;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Service
public class SimpleRestService {
    // @Autowired
    private RestTemplate restTemplate = new RestTemplate();

    public String getMessage() {
        String result = null;
        try {
            String httpResult = restTemplate.getForObject("http://google.com", String.class);
            System.out.println(httpResult);
            System.out.println("test111");
            System.out.println("test1112 ---------");

            result = "Message SUCCESS result: " + httpResult;  // Wait here ?
            System.out.println(result);
            System.out.println("test");
            System.out.println("test2 ---------");
        } catch (HttpStatusCodeException e) {
            result = "Get FAILED with HttpStatusCode: " + e.getStatusCode() + "|" + e.getStatusText();
        } catch (RuntimeException e) {
            result = "Get FAILED\n" + ExceptionUtils.getFullStackTrace(e);
        }
        return result;
    }

    public static void main(String[] args) {
        SimpleRestService simpleRestService = new SimpleRestService();
        System.out.println(simpleRestService.getMessage());

    }
}
