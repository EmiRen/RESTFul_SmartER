package restws;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import restws.Credential;
import restws.Usage;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-24T14:07:11")
@StaticMetamodel(Resident.class)
public class Resident_ { 

    public static volatile SingularAttribute<Resident, Integer> nor;
    public static volatile SingularAttribute<Resident, String> firstname;
    public static volatile SingularAttribute<Resident, String> address;
    public static volatile SingularAttribute<Resident, String> provider;
    public static volatile CollectionAttribute<Resident, Usage> usageCollection;
    public static volatile SingularAttribute<Resident, String> surname;
    public static volatile SingularAttribute<Resident, Date> dob;
    public static volatile CollectionAttribute<Resident, Credential> credentialCollection;
    public static volatile SingularAttribute<Resident, String> postcode;
    public static volatile SingularAttribute<Resident, String> mobile;
    public static volatile SingularAttribute<Resident, Integer> resid;
    public static volatile SingularAttribute<Resident, String> email;

}