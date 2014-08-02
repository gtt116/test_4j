import org.openstack4j.api.OSClient;
import org.openstack4j.model.compute.Flavor;
import org.openstack4j.model.compute.Server;
import org.openstack4j.model.identity.User;
import org.openstack4j.openstack.OSFactory;

public class monkey {

    public static void main(String[] args) {

        /* init os object with username, password, tenantname */
        OSClient os = OSFactory.builder().
        endpoint("http://127.0.0.1:5000/v2.0").
        credentials("jenkins", "jenkinsgtt").
        tenantName("jenkins").
        authenticate();
        
        /* get all users */
        for(User user: os.identity().users().list()){
            System.out.println(user);
        }
        
        /* get all instances */
        for(Server server: os.compute().servers().list()){
            System.out.println(server);
        }
        
        /* get a flavor */
        String flavor_id="1";
        Flavor flavor = os.compute().flavors().get(flavor_id);
        System.out.println(flavor.getName());

        /* get all volumes */
        os.blockStorage().volumes().list();
    }

}

