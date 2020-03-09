import javax.persistence.*;

import org.hibernate.*;
import org.hibernate.query.Query;


import java.util.List;
/*@Autowired
ElevService elevService;*/
// -> fara instantiere... pentru folosire
public class HibernateRunner {

    public static void main(String[] args) {
    /*    Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();*/

       /* Elev elev = session.find(Elev.class, 2);
        Elev altElev = session.find(Elev.class, 4);

        System.out.println(elev.toString());
        System.out.println(altElev.toString());

        Clasa clasa = session.find(Clasa.class, 1);
        System.out.println(clasa);

        Elev elevNou = new Elev();
        elevNou.clasaDeCareApartineElevul = clasa;
        elevNou.numeElev = "Ghita de la portita";

        System.out.println("Inainte de save:" + elevNou);
        session.save(elevNou);
        System.out.println("Dupa save:" + elevNou);



        Materie materie = session.find(Materie.class,1);
        System.out.println(materie);*/

    /*    String hql = "delete from Elev "  +
                "where idElev = :idElev";
        Query query = session.createQuery(hql);
        query.setParameter("idElev", 14);
        query.executeUpdate();
        query.setParameter("idElev", 15);
        query.executeUpdate();
        query.setParameter("idElev", 16);
        query.executeUpdate();
        query.setParameter("idElev", 17);
        query.executeUpdate();
        query.setParameter("idElev", 18);
        query.executeUpdate();
        //System.out.println("Rows affected: " + query.executeUpdate());*/

       /* String hql2 = "from Elev";
        Query query2 = session.createQuery(hql2);
        List<Elev> elevi = query2.list();

        for (Elev e: elevi ) {
            System.out.println(e);
        }
*/

       /* Query query = session.createQuery("from Elev e where e.idElev > 3" + " group by e.clasaDeCareApartineElevul.numeClasa");
        List<Elev> elevi = query.list();
        //System.out.println(results);
        for (Elev e: elevi ) {
            System.out.println(e);
        }*/

        /*String intrebare1 = "Select e.numeElev from Elev e";
        Query query=session.createQuery(intrebare1);
        List lista1 = query.list();
        System.out.println(lista1);
        System.out.println("_________________________________");
        String intrebare2 = "Select e.idElev from Elev e where idElev = 3";
        query = session.createQuery(intrebare2);
        List lista2 = query.list();
        System.out.println(lista2);
        System.out.println("_________________________________");
        String intrebare3 = "from Predare pm " + "Order by pm.idPredare";
        query = session.createQuery(intrebare3);
        List lista3 = query.list();
        System.out.println(lista3);*/

        /*String intrebareMea2 = "select n.idNota from Nota n where n.elevulCareAObtinutNota.idElev = 10 ";
        Query query = session.createQuery(intrebareMea2);
        List listaMea2 = query.list();
        System.out.println(listaMea2);*/

       /* String intrebare = "from Elev where numeElev like 'z%' ";
        Query query = session.createQuery(intrebare);
        List lista1 = query.list();
        System.out.println(lista1);

        String intrebare1 = "from Elev e where e.idElev < 10 " + " and e.clasaDeCareApartineElevul.numeClasa = '10B' ";
        query = session.createQuery(intrebare1);
        List lista2 = query.list();
        System.out.println(lista2);

        String intrebare2 = "SELECT noteleElevului from Elev e where numeElev like '%e' ";
        query = session.createQuery(intrebare2);
        List lista3 = query.list();
        System.out.println(lista3);

        String intrebare3 = "select count (*) from Elev e where e.clasaDeCareApartineElevul.numeClasa = '10A'";
        query = session.createQuery(intrebare3);
        Object lista4 = query.getSingleResult();
        System.out.println(lista4);

        String intrebare4 = "select c.numeClasa from Clasa c where c.eleviiDinClasa.size < 10";
        query = session.createQuery(intrebare4);
        List lista5 = query.list();
        System.out.println(lista5);*/

        /*String intrebare3 = " from Elev e where e.clasaDeCareApartineElevul.numeClasa = :numeClasa";
        Query query = session.createQuery(intrebare3);
        query.setParameter("numeClasa","10B");
        List<Elev> lista4 = query.list();
        System.out.println(lista4);

        Query elevByNume = session.createQuery("select e.numeElev from Elev e "+
                "where e.numeElev like :numeCautat");
        elevByNume.setParameter("numeCautat","%zar%");
        elevByNume.setMaxResults(1);
        Elev elevulNostru = (Elev) elevByNume.getSingleResult();

        System.out.println(elevulNostru);


        transaction.commit();
*/


        ElevService es = ElevService.getInstance(); //singleton
        Elev zar = es.getElevByName("zar");

        System.out.println(zar);

        List<Elev> eleviByClassName10A = es.getEleviByClassName("10A");
        List<Elev> eleviByClassName10B = es.getEleviByClassName("10B");
        List<Elev> eleviByClassName10C = es.getEleviByClassName("10C");

        System.out.println(eleviByClassName10A);
        System.out.println(eleviByClassName10B);
        System.out.println(eleviByClassName10C);


        HibernateUtil.shutdown();
    }
}