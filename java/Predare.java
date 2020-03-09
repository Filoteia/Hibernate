import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "profesorimaterie")
public class Predare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPredare")
    public int idPredare;

    @ManyToOne
    @JoinColumn(name = "idProfesor")
    public Profesor profesorulCarePreda;

    @ManyToOne
    @JoinColumn(name = "idMaterie")
    public Materie materiaPredata;

    @OneToMany(mappedBy = "predareaPrinCareNotaAFostObtinuta")
    public List<Nota> noteleAcordateLaPredare;

    @Override
    public String toString() {
        return "Predare{" +
                "idPredare=" + idPredare +
                ", profesorulCarePreda=" + profesorulCarePreda +
                ", materiaPredata=" + materiaPredata +
                ", noteleAcordateLaPredare=" + noteleAcordateLaPredare +
                '}';
    }
}
