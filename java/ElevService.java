import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ElevService {

    private static ElevService INSTANCE;

    private ElevService() {
    }

    public static ElevService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ElevService();
        }
        return INSTANCE;
    }

    public List<Elev> getEleviByClassName(String className) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        String intrebare3 = " from Elev e where e.clasaDeCareApartineElevul.numeClasa = :numeClasa";
        Query eleviByClassName = session.createQuery(intrebare3);
        eleviByClassName.setParameter("numeClasa", className);
        List<Elev> eleviList = eleviByClassName.list();

        return eleviList;

    }

    public Elev getElevByName(String wantedName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query elevByNume = session.createQuery("select e.numeElev from Elev e " +
                "where e.numeElev like :numeCautat");

        elevByNume.setParameter("numeCautat", "%" + wantedName + "%");
        elevByNume.setMaxResults(1);

        Elev elevulNostru = (Elev) elevByNume.getSingleResult();
        return elevulNostru;
    }
}