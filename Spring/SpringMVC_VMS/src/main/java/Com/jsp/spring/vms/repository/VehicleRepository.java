package Com.jsp.spring.vms.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import Com.jsp.spring.vms.entity.Vehicle;

@Repository
public class VehicleRepository {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql-config");

	public void saveVehicle(Vehicle vehicle) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		em.persist(vehicle);

		et.commit();
		em.close();
	}

	public List<Vehicle> findAllVehicle() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		Query query = em.createQuery("FROM Vehicle");
		List<Vehicle> vehicles = query.getResultList();
		
		et.commit();
		em.close();

		return vehicles;
	}

	public Vehicle findById(int vehicleId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		Vehicle vehicle = em.find(Vehicle.class, vehicleId);
		
		et.commit();
		em.close();

		return vehicle;
		
	}

	public void updateVehicle(Vehicle vehicle) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		em.merge(vehicle);
		
		et.commit();
		em.close();
		
	}
}
