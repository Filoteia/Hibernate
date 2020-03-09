import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clasa")
public class Clasa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idClasa")
    public int idClasa;

    @Column(name = "numeClasa")
    public String numeClasa;

    @OneToMany(mappedBy = "clasaDeCareApartineElevul")
    public List<Elev> eleviiDinClasa;

    @Override
    public String toString() {
        return "Clasa{" +
                "idClasa=" + idClasa +
                ", numeClasa='" + numeClasa + '\'' +
                ", eleviiDinClasa=" + eleviiDinClasa +
                '}';
    }
}
