import converter.ClientConverter;
import dto.ClientsDTO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.client.RestTemplate;
import provider.ClientProvider;
import provider.RestClientProvider;

public class App {
    public static final String URL = "http://localhost:8080/api/clients";

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        "clientconfig"
                );

        ClientProvider clientProvider = (ClientProvider) context.getBean(RestClientProvider.class);

        clientProvider.getAllSortedAscendingByFields(new String[]{"age"}).getClients().forEach(System.out::println);
    }
}
