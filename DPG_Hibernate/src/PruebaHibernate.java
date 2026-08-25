import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;

public class PruebaHibernate {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {

            List<Usuario> usuarios = session
                    .createQuery("FROM Usuario", Usuario.class)
                    .getResultList();

            System.out.println("=== USUARIOS CONSULTADOS CON HIBERNATE ===");

            for (Usuario usuario : usuarios) {
                System.out.println(usuario);
            }

        } catch (Exception e) {
            System.err.println("Error al consultar usuarios: " + e);
        } finally {
            sessionFactory.close();
        }
    }
}