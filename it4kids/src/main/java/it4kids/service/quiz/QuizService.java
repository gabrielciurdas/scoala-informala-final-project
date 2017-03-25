package it4kids.service.quiz;

import it4kids.dao.indatabase.quiz.OptionDAO;
import it4kids.dao.indatabase.quiz.QuizDAO;
import it4kids.dao.indatabase.quiz.QuizEntryDAO;
import it4kids.domain.quiz.Option;
import it4kids.domain.quiz.Quiz;
import it4kids.domain.quiz.QuizEntry;

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
	private QuizDAO quizDao;
	

	public Collection<Quiz> listAllQuiz() {
		return quizDao.getAll();
	}

	public Collection<Quiz> searchQuiz(String query) {
		LOGGER.debug("Searching for " + query);
		return quizDao.searchByName(query);
	}

	public boolean deleteQuiz(Long id) {
		LOGGER.debug("Deleting quiz for id: " + id);
		Quiz emp = quizDao.findById(id);
		if (emp != null) {
			quizDao.delete(emp);
			return true;
		}

		return false;
	}

	public Quiz getQuiz(Long id) {
		LOGGER.debug("Getting quiz for id: " + id);
		return quizDao.findById(id);

	}

	public void save(Quiz quiz) throws it4kids.service.ValidationException {
		LOGGER.debug("Saving: " + quiz);
		validate(quiz);

		quizDao.update(quiz);
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

	public QuizDAO getQuizDao() {
		return quizDao;
	}

	public void setQuizDao(QuizDAO dao) {
		this.quizDao = dao;
	}
	
	@Autowired
	private QuizEntryDAO quizEntryDao;

	public Collection<QuizEntry> listAllQuizEntry() {
		return quizEntryDao.getAll();
	}

	public Collection<QuizEntry> searchQuizEntry(String query) {
		LOGGER.debug("Searching for " + query);
		return quizEntryDao.searchByName(query);
	}

	public boolean deleteQuizEntry(Long id) {
		LOGGER.debug("Deleting question for id: " + id);
		QuizEntry emp = quizEntryDao.findById(id);
		if (emp != null) {
			quizEntryDao.delete(emp);
			return true;
		}

		return false;
	}

	public QuizEntry getQuizEntry(Long id) {
		LOGGER.debug("Getting quiz for id: " + id);
		return quizEntryDao.findById(id);

	}

	public void save(QuizEntry list)
			throws it4kids.service.ValidationException {
		LOGGER.debug("Saving: " + list);
		validate(list);

		quizEntryDao.update(list);
	}

	private void validate(QuizEntry list)
			throws it4kids.service.ValidationException {
		List<String> errors = new LinkedList<String>();
		if (StringUtils.isEmpty(list.getClass())) {
			errors.add("There is no question");
		}


		if (list.getOption() == null) {
			errors.add("There are no answears");
		}

		if (!errors.isEmpty()) {
			throw new it4kids.service.ValidationException(
					errors.toArray(new String[] {}));
		}
	}

	public QuizEntryDAO getQuizEntryDao() {
		return quizEntryDao;
	}

	public void setQuizEntryDao(QuizEntryDAO dao) {
		this.quizEntryDao = dao;
	}

	@Autowired
	private OptionDAO optionDao;

	public Collection<Option> listAllOption() {
		return optionDao.getAll();
	}

	public Collection<Option> searchOption(String query) {
		LOGGER.debug("Searching for " + query);
		return optionDao.searchByName(query);
	}

	public boolean deleteOption(Long id) {
		LOGGER.debug("Deleting quiz for id: " + id);
		Option emp = optionDao.findById(id);
		if (emp != null) {
			optionDao.delete(emp);
			return true;
		}

		return false;
	}

	public Option getOption(Long id) {
		LOGGER.debug("Getting quiz for id: " + id);
		return optionDao.findById(id);

	}

	public void save(Option option)
			throws it4kids.service.ValidationException {
		LOGGER.debug("Saving: " + option);
		validate(option);

		optionDao.update(option);
	}

	private void validate(Option option)
			throws it4kids.service.ValidationException {
		List<String> errors = new LinkedList<String>();
		if (StringUtils.isEmpty(option.getClass())) {
			errors.add("Name is Empty");
		}

		if (option.getText() == null) {
			errors.add("There are no questions");
		}

		if (!errors.isEmpty()) {
			throw new it4kids.service.ValidationException(
					errors.toArray(new String[] {}));
		}
	}

	public OptionDAO getOptionDao() {
		return optionDao;
	}

	public void setOptionDao(OptionDAO dao) {
		this.optionDao = dao;
	}
}
