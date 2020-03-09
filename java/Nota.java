
import javax.persistence.*;

@Entity
@Table(name = "note")
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idNota")
    public int idNota;

    @Column(name = "valoareNota")
    public int valoareNota;

    @ManyToOne
    @JoinColumn(name = "idElev")
    public Elev elevulCareAObtinutNota;

    @ManyToOne
    @JoinColumn(name = "idPredare")
    public Predare predareaPrinCareNotaAFostObtinuta;

    @Override
    public String toString() {
        return "Nota{" +
                "idNota=" + idNota +
                ", valoareNota=" + valoareNota +
                ", elevulCareAObtinutNota=" + elevulCareAObtinutNota.numeElev +
                ", predareaPrinCareNotaAFostObtinuta=" + predareaPrinCareNotaAFostObtinuta.idPredare +
                '}';
    }
}
