package restws;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import restws.Resident;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-24T14:07:11")
@StaticMetamodel(Credential.class)
public class Credential_ { 

    public static volatile SingularAttribute<Credential, String> passwordhash;
    public static volatile SingularAttribute<Credential, Resident> resid;
    public static volatile SingularAttribute<Credential, Date> registdate;
    public static volatile SingularAttribute<Credential, String> username;

}