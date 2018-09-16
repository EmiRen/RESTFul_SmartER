/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restws.service;

import entities.Appliance;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import restws.Usage;

/**
 *
 * @author RenJie
 */
@Stateless
@Path("restws.usage")
public class UsageFacadeREST extends AbstractFacade<Usage> {

    @PersistenceContext(unitName = "SmartERPU")
    private EntityManager em;

    public UsageFacadeREST() {
        super(Usage.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Usage entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Usage entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Usage find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    //Task 3.1
    
    @GET
    @Path("findByUsageid/{usageid}")
    @Produces({"application/json"})
    public List<Usage> findByUsageid(@PathParam("usageid") Integer usageid) {
        Query query = em.createNamedQuery("Usage.findByUsageid");
        query.setParameter("usageid", usageid);
        return query.getResultList();
    }
    
    @GET
    @Path("findByResid/{resid}")
    @Produces({"application/json"})
    public List<Usage> findByResid(@PathParam("resid") Integer resid) {
        Query query = em.createNamedQuery("Usage.findByResid");
        query.setParameter("resid", resid);
        return query.getResultList();
    }
    
    @GET
    @Path("findByDate/{date}")
    @Produces({"application/json"})
    public List<Usage> findByDate(@PathParam("date") Date date) {
        Query query = em.createNamedQuery("Usage.findByDate");
        query.setParameter("date", date);
        return query.getResultList();
    }
    
    @GET
    @Path("findByUsagehour/{usagehour}")
    @Produces({"application/json"})
    public List<Usage> findByUsagehour(@PathParam("usagehour") Integer usagehour) {
        Query query = em.createNamedQuery("Usage.findByUsagehour");
        query.setParameter("usagehour", usagehour);
        return query.getResultList();
    } 
    
    @GET
    @Path("findByFridgeusage/{fridgeusage}")
    @Produces({"application/json"})
    public List<Usage> findByFridgeusage(@PathParam("fridgeusage") Double fridgeusage) {
        Query query = em.createNamedQuery("Usage.findByFridgeusage");
        query.setParameter("fridgeusage", fridgeusage);
        return query.getResultList();
    }
    
    @GET
    @Path("findByAirconusage/{airconusage}")
    @Produces({"application/json"})
    public List<Usage> findByAirconusage(@PathParam("airconusage") Double airconusage) {
        Query query = em.createNamedQuery("Usage.findByAirconusage");
        query.setParameter("airconusage", airconusage);
        return query.getResultList();
    }
    
    @GET
    @Path("findByWashusage/{washusage}")
    @Produces({"application/json"})
    public List<Usage> findByWashusage(@PathParam("washusage") Double washusage) {
        Query query = em.createNamedQuery("Usage.findByWashusage");
        query.setParameter("washusage", washusage);
        return query.getResultList();
    }
    
    @GET
    @Path("findByTemperature/{temperature}")
    @Produces({"application/json"})
    public List<Usage> findByTemperature(@PathParam("temperature") Integer temperature) {
        Query query = em.createNamedQuery("Usage.findByTemperature");
        query.setParameter("temperature", temperature);
        return query.getResultList();
    }
    
    //end 3.1

    
    //Task 3.3
    
    @GET
    @Path("findByFirstnameANDDate/{firstname}/{date}")
    @Produces({"application/json"})
    public List<Usage> findByFirstnameANDDate(@PathParam("firstname") String firstname, @PathParam("date") Date date) {
        TypedQuery<Usage> q = em.createQuery("SELECT u FROM Usage u WHERE UPPER(u.resid.firstname) = UPPER(:firstname) AND u.date = :date", Usage.class);
        q.setParameter("firstname", firstname);
        q.setParameter("date", date);
        return q.getResultList();
    }
    
    //end 3.3
    
    
    //Task 3.4
    
    @GET
    @Path("findBySurnameANDDate/{surname}/{date}")
    @Produces({"application/json"})
    public List<Usage> findBySurnameANDDate(@PathParam("surname") String surname, @PathParam("date") Date date) {
        Query query = em.createNamedQuery("Usage.findBySurnameANDDate");
        query.setParameter("surname", surname);
        query.setParameter("date", date);
        return query.getResultList();
    }
    
    //end 3.4
    
    
    //Task 4.1
  
    @GET
    @Path("UsageofSpecifiedAppliance/{resid}/{date}/{usagehour}/{appliance}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Appliance> UsageofSpecifiedAppliance(@PathParam("resid") Integer resid, @PathParam("date") Date date, 
                                                     @PathParam("usagehour") Integer usagehour, @PathParam("appliance") String appliance){
        TypedQuery<Object[]> q = em.createQuery("SELECT u.resid.resid,u.date,u.usagehour,u.fridgeusage,u.airconusage,u.washusage FROM Usage AS u " +
                                                "WHERE u.resid.resid = :resid AND u.date = :date AND u.usagehour = :usagehour", Object[].class);
        q.setParameter("resid", resid);
        q.setParameter("date", date);
        q.setParameter("usagehour", usagehour);
        List<Object[]> queryList = q.getResultList();
        List<Appliance> finalResult = new ArrayList<>();
        
        switch (appliance) {
            case "fridge":
                for(Object[] row : queryList){
                    finalResult.add(new Appliance (
                            (Integer) row[0], 
                            (java.util.Date) row[1], 
                            (Integer) row[2], 
                            (Double) row[3]));
                }
                return finalResult;
            case "airconditioner":
                for(Object[] row : queryList){
                    finalResult.add(new Appliance (
                            (Integer) row[0], 
                            (java.util.Date) row[1], 
                            (Integer) row[2], 
                            (Double) row[3]));
                }
                return finalResult;
            case "washingmachine":
                for(Object[] row : queryList){
                    finalResult.add(new Appliance (
                            (Integer) row[0], 
                            (java.util.Date) row[1], 
                            (Integer) row[2], 
                            (Double) row[3]));
                }
                return finalResult;
            default:
                break;
        }
        return null;
    }
    
    //end 4.1
    
    
    //Task4.2
    
    @GET
    @Path("UsageofThreeAppliance/{resid}/{date}/{usagehour}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Appliance> UsageofThreeAppliance(@PathParam("resid") Integer resid, @PathParam("date") Date date, @PathParam("usagehour") Integer usagehour){
        TypedQuery<Object[]> q = em.createQuery("SELECT u.resid.resid,u.date,u.usagehour,u.fridgeusage+u.airconusage+u.washusage FROM Usage AS u " +
                                                "WHERE u.resid.resid = :resid AND u.date = :date AND u.usagehour = :usagehour", Object[].class);
        q.setParameter("resid", resid);
        q.setParameter("date", date);
        q.setParameter("usagehour", usagehour);
        List<Object[]> queryList = q.getResultList();
        List<Appliance> finalResult = new ArrayList<>();
        for(Object[] row : queryList){
            finalResult.add(new Appliance (
                    (Integer) row[0], 
                    (java.util.Date) row[1], 
                    (Integer) row[2], 
                    (Double) row[3]));
        }
        return finalResult;
    }
    
    //end 4.2
    
    
    //Task 4.3
    
    @GET
    @Path("UsageofTotalHourUsage/{date}/{usagehour}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Appliance> UsageofTotalHourUsage(@PathParam("date") Date date, @PathParam("usagehour") Integer usagehour){
        TypedQuery<Object[]> q = em.createQuery("SELECT u.resid.resid,u.resid.address,u.resid.postcode,u.fridgeusage+u.airconusage+u.washusage FROM Usage AS u " +
                                                "WHERE u.date = :date AND u.usagehour = :usagehour", Object[].class);
        q.setParameter("date", date);
        q.setParameter("usagehour", usagehour);
        List<Object[]> queryList = q.getResultList();
        List<Appliance> finalResult = new ArrayList<>();
        
        for(Object[] row : queryList){
            finalResult.add(new Appliance (
                    (Integer) row[0], 
                    (String) row[1], 
                    (String) row[2], 
                    (Double) row[3]));
        }
        return finalResult;
    }
    
    //end 4.3
    
    //Task 4.4
    
    @GET
    @Path("HighestUsageHour/{resid}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Appliance> HighestUsageHour(@PathParam("resid") Integer resid){
        TypedQuery<Object[]> q = em.createQuery("SELECT u.resid.resid,u.date,u.usagehour,u.fridgeusage+u.airconusage+u.washusage FROM Usage AS u " +
                                                "WHERE u.resid.resid = :resid", Object[].class);
        q.setParameter("resid", resid);
        List<Object[]> queryList = q.getResultList();
        List<Appliance> finalResult = new ArrayList<>();
        
        Double maxUsage = 0.0;
        for(Object[] row : queryList){
            if((Double)row[3] > maxUsage){
                maxUsage = (Double)row[3];
                finalResult.clear();
                finalResult.add(new Appliance (
                        (Integer) row[0],  
                        (java.util.Date) row[1],                     
                        (Integer) row[2],
                        (Double) row[3]));
            }
        }
        return finalResult;
    }
    
    //end 4.4 
    
    
    //Task 5.1
    
    @GET
    @Path("DaliyUsageofAppliances/{resid}/{date}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Object DaliyUsageofAppliances(@PathParam("resid") Integer resid, @PathParam("date") Date date){
        TypedQuery<Object[]> q = em.createQuery("SELECT u.resid.resid,sum(u.washusage),sum(u.fridgeusage),sum(u.airconusage) FROM Usage AS u " +
                                                "WHERE u.resid.resid = :resid AND u.date = :date GROUP BY u.resid.resid", Object[].class);
                      
        q.setParameter("resid", resid);
        q.setParameter("date", date);
        List<Object[]> queryList = q.getResultList();
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        DecimalFormat df = new DecimalFormat("#.##");
        
        for(Object[] row : queryList){
            JsonObject usageObject = Json.createObjectBuilder().
                            add("resid", (Integer)row[0])
                            .add("washingmachine", df.format((Double)row[1]))
                            .add("fridge", df.format((Double)row[2]))
                            .add("aircon", df.format((Double)row[3])).build();
            arrayBuilder.add(usageObject);
        }
        JsonArray jArray = arrayBuilder.build();

        return jArray;
    }
    
    //end 5.1
    
    
    //Task 5.2
    
    @GET
    @Path("HourlyOrDarilyUsage/{resid}/{date}/{hourlyOrDaily}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Appliance> HourlyOrDarilyUsage(@PathParam("resid") Integer resid, @PathParam("date") Date date, @PathParam("hourlyOrDaily") String hourlyOrDaily){
        if(hourlyOrDaily.equals("hourly")){
            TypedQuery<Object[]> q = em.createQuery("SELECT u.resid.resid,u.date,u.usagehour,u.temperature,u.fridgeusage+u.airconusage+u.washusage FROM Usage AS u " +
                                                  "WHERE u.date = :date AND u.resid.resid = :resid", Object[].class);
            q.setParameter("resid", resid);
            q.setParameter("date", date);
            List<Object[]> queryList = q.getResultList();
            List<Appliance> finalResult = new ArrayList<>();
        
            for(Object[] row : queryList){
                finalResult.add(new Appliance (
                        (Integer) row[0], 
                        (java.util.Date) row[1], 
                        (Integer) row[2], 
                        (Double) row[3],
                        (Double) row[4]));
            }
            return finalResult;
        }
        else if(hourlyOrDaily.equals("daily")){
            TypedQuery<Object[]> q = em.createQuery("SELECT u.resid.resid,AVG(u.temperature),sum(u.washusage+u.fridgeusage+u.airconusage) FROM Usage AS u " +
                                                    "WHERE u.date = :date AND u.resid.resid = :resid GROUP BY u.resid.resid", Object[].class);
            q.setParameter("resid", resid);
            q.setParameter("date", date);
            List<Object[]> queryList = q.getResultList();
            List<Appliance> finalResult = new ArrayList<>();
        
            for(Object[] row : queryList){
                finalResult.add(new Appliance (
                        (Integer) row[0], 
                        Math.round((Double) row[1] * 100.0)/100.0, 
                        Math.round((Double) row[2] * 100.0)/100.0));
            }
            return finalResult;  
        }
        return null;
    }
    
    //end 5.2
    
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Usage> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Usage> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    
}
