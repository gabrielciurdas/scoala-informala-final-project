package it4kids.service.quiz;

import it4kids.dao.indatabase.quiz.QuizDAO;
import it4kids.domain.quiz.Quiz;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class QuizService {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(QuizService.class);

	@Autowired
	private QuizDAO dao;

	public Collection<Quiz> listAll() {
		return dao.getAll();
	}

	public Collection<Quiz> search(String query) {
		LOGGER.debug("Searching for " + query);
		return dao.searchByName(query);
	}

	public boolean delete(Long id) {
		LOGGER.debug("Deleting quiz for id: " + id);
		Quiz emp = dao.findById(id);
		if (emp != null) {
			dao.delete(emp);
			return true;
		}

		return false;
	}

	public Quiz get(Long id) {
		LOGGER.debug("Getting quiz for id: " + id);
		return dao.findById(id);

	}

	public void save(Quiz employee) throws it4kids.service.ValidationException {
		LOGGER.debug("Saving: " + employee);
		validate(employee);

		dao.update(employee);
	}

	private void validate(Quiz quiz) throws it4kids.service.ValidationException {
		List<String> errors = new LinkedList<String>();
		if (StringUtils.isEmpty(quiz.getClass())) {
			errors.add("Name is Empty");
		}

		if (quiz.getQuestions() == null) {
			errors.add("There are no questions");
		}

		if (!errors.isEmpty()) {
			throw new it4kids.service.ValidationException(
					errors.toArray(new String[] {}));
		}
	}

	public QuizDAO getDao() {
		return dao;
	}

	public void setDao(QuizDAO dao) {
		this.dao = dao;
	}

	// // service 1 , listeaza toate quizurile disponibile.
	// public Collection<Quiz> listAll() {
	// return dao.getAll();
	// }
	//
	// // service 2 delete quiz
	// public boolean deleteQuiz() {
	// return false;
	// }
	//
	// // service 3 create quiz
	// public boolean createQuiz() {
	// return false;
	// }
	//
	// // service 4 edit quiz ? (despre asta nu-s sigur , s-ar putea sa fie de
	// // ajuns daca avem edit question pentru fiecare quiz in parte)
	// // sau ar putea fi editat numele , timpul , etc.
	// public boolean editQuiz() {
	// return false;
	// }
}
