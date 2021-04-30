package fr.uphf.RestServer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.uphf.RestServer.model.Operation;

/**
 * OperationRepository : Interface qui implemente la couche d'accès aux données operations
 * pour le serveur Tomcat (Bank)
 * @author Quentin Colras
 *
 */
@Repository
public interface OperationRepository extends CrudRepository<Operation, Long> {

	/*@Modifying
	@Transactional
	@Query( value = "insert into operations (Op, Old_Balance, Value_Op, Date_Op, Id_Client) values "
			+ "(:op, :oldBalance, :valueOp, :strDateOp, :id)", nativeQuery = true)
	void test(@Param("op") char op, @Param("oldBalance") Float oldBalance, @Param("valueOp") Float valueOp,
			@Param("strDateOp")String strDateOp, @Param("id") Long id);*/

	Iterable<Operation> findAllByTypeContaining(String type);
}