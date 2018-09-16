package restws;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import restws.Resident;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-24T14:07:11")
@StaticMetamodel(Usage.class)
public class Usage_ { 

    public static volatile SingularAttribute<Usage, Date> date;
    public static volatile SingularAttribute<Usage, Double> fridgeusage;
    public static volatile SingularAttribute<Usage, Integer> usageid;
    public static volatile SingularAttribute<Usage, Integer> usagehour;
    public static volatile SingularAttribute<Usage, Integer> temperature;
    public static volatile SingularAttribute<Usage, Double> airconusage;
    public static volatile SingularAttribute<Usage, Resident> resid;
    public static volatile SingularAttribute<Usage, Double> washusage;

}