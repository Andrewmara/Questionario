package it.f2informatica.questionari.repository;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import it.f2informatica.questionari.domain.Domande;
import it.f2informatica.questionari.domain.Questionario;
import it.f2informatica.questionari.domain.QuestionarioUtente;
import it.f2informatica.questionari.domain.RisposteUtente;
import it.f2informatica.questionari.domain.Utente;
import it.f2informatica.questionari.service.domandaInterface;
import it.f2informatica.questionari.service.questionarioInterface;
import it.f2informatica.questionari.service.questionarioUtenteInterface;
import it.f2informatica.questionari.service.risposteInterface;
import it.f2informatica.questionari.service.utenteInterface;

@Repository(value="MYSQL")
public class JDBCRepository implements utenteInterface,questionarioInterface,domandaInterface,questionarioUtenteInterface,risposteInterface{
	private Logger logger = LoggerFactory.getLogger(JDBCRepository.class);
	@Autowired
	JdbcTemplate jdbcTemplate;
	
//------------Utente-----------------------------
	@Override
	public int save(Utente u) {
		logger.debug("Repository: Utente {}",u);
		return jdbcTemplate.update("INSERT INTO utente(nome,cognome,email,password,ruolo) VALUE(?,?,?,?,?)", new Object[] {u.getNome(), u.getCognome(), u.getEmail(), u.getPassword(),u.getRuolo()});
	}
	
	@Override
	public List<Utente> findAll() {
		logger.debug("Repository:tutti gli utenti");
		return jdbcTemplate.query("SELECT * FROM utente", BeanPropertyRowMapper.newInstance(Utente.class));
	}
	
	@Override
	public Utente findById(int id_utente) {
		logger.debug("Repository: id utente: {}",id_utente);
		return jdbcTemplate.queryForObject("SELECT * FROM utente WHERE id=?", BeanPropertyRowMapper.newInstance(Utente.class),id_utente);
	}

	@Override
	public Utente findByEmail2(String email) {
		logger.debug("Repository: email utente: {}",email);
		return jdbcTemplate.queryForObject("SELECT * FROM utente WHERE email=?", BeanPropertyRowMapper.newInstance(Utente.class),email);
	}

//-------------Questionario----------------------
	@Override
	public Long saveQuest(Questionario q) {
		logger.debug("Repository: Questionario {}",q);
		return (long) jdbcTemplate.update("INSERT INTO questionario(titolo,descrizione,id_utente) VALUE(?,?,?)",new Object[] {q.getTitolo(), q.getDescrizione(), q.getId_utente()});
	}

	@Override
	public List<Questionario> findAllQuest() {
		logger.debug("Repository:tutti i questionari");
		return jdbcTemplate.query("SELECT * FROM questionario", BeanPropertyRowMapper.newInstance(Questionario.class));
	}
	
	@Override
	public List<Questionario> findQuestByDocente(Long id_utente) {
		logger.debug("Repository:tutti i questionari");
		return jdbcTemplate.query("SELECT questionario.id, questionario.descrizione, questionario.id_utente, questionario.titolo FROM questionario INNER JOIN utente \r\n"
				+ "ON questionario.id_utente = utente.id\r\n"
				+ "WHERE questionario.id_utente = ?", BeanPropertyRowMapper.newInstance(Questionario.class),id_utente);
	}
	
	@Override
	public Long idQuestionario(String titolo,String descrizione,Long docente) {
		return jdbcTemplate.queryForObject("SELECT q.id\r\n"
				+ "FROM questionario q\r\n"
				+ "WHERE q.titolo = ? AND q.descrizione = ? AND q.id_utente = ?",Long.class,titolo,descrizione,docente);
	}
//-------------Domande---------------------------
	@Override
	public int saveDoma(Domande d) {
		logger.debug("Repository: Domande {}",d);
		return jdbcTemplate.update("INSERT INTO domande(domanda,id_questionario,giusta,ris_uno,ris_due,ris_tre,punteggio) VALUE(?,?,?,?,?,?,?)",new Object[] {d.getDomanda(), d.getId_questionario(), d.getGiusta(),d.getRis_uno(),d.getRis_due(),d.getRis_tre(),d.getPunteggio()});
		
	}

	@Override
	public List<Domande> findAllDoma() {
		logger.debug("Repository:tutte le domande");
		return jdbcTemplate.query("SELECT * FROM domande", BeanPropertyRowMapper.newInstance(Domande.class));
	}
	
	@Override
	public List<Domande> findAllDomaByQuestId(int id_questionario) {
		logger.debug("Repository:tutte le domande id del questionario");
		return jdbcTemplate.query("SELECT * FROM domande WHERE id_questionario=?", BeanPropertyRowMapper.newInstance(Domande.class),id_questionario);
	}
	
	@Override
	public Integer nDomande(int questionario) {
		return jdbcTemplate.queryForObject("SELECT COUNT(d.domanda)\r\n"
				+ "FROM domande d\r\n"
				+ "WHERE d.id_questionario = ?", Integer.class,questionario);
	}
	
	@Override
	public Integer Ptot(int questionario) {
		return jdbcTemplate.queryForObject("SELECT SUM(d.punteggio)\r\n"
				+ "FROM domande d\r\n"
				+ "WHERE d.id_questionario = ?", Integer.class,questionario);
	}
	
	
//------------QuestionarioUtente-----------------
	@Override
	public int saveQU(QuestionarioUtente qu) {
		logger.debug("Repository: QuestionarioUtente {}",qu);
		return jdbcTemplate.update("INSERT INTO questionario_utente(id_questionario,id_utente,punteggio) VALUE(?,?,?)",new Object[] {qu.getId_questionario(), qu.getId_utente(), qu.getPunteggio()});
		
	}

	@Override
	public List<QuestionarioUtente> findAllQU() {
		logger.debug("Repository:tutti i punteggi");
		return jdbcTemplate.query("SELECT * FROM questionario_utente", BeanPropertyRowMapper.newInstance(QuestionarioUtente.class));
	}
	
	@Override
	public Integer countCandidati(int questionario) {
		return jdbcTemplate.queryForObject("SELECT count(q.id_utente) \r\n"
				+ "FROM questionario_utente q\r\n"
				+ "WHERE q.id_questionario = ?",Integer.class,questionario);
	}
	
	@Override
	public Integer mediaPunteggi(int questionario) {
		return jdbcTemplate.queryForObject("SELECT AVG(q.punteggio)\r\n"
				+ "FROM questionario_utente q\r\n"
				+ "WHERE q.id_questionario = ?",Integer.class,questionario);
	}
	
	@Override
	public List<Utente> findUserOfQuest(int questionario) {
		return jdbcTemplate.query("SELECT u.nome, u.cognome, u.id \r\n"
				+ "FROM questionario_utente q INNER JOIN utente u\r\n"
				+ "ON q.id_utente = u.id\r\n"
				+ "INNER JOIN ruolo r\r\n"
				+ "ON r.ruolo = u.ruolo\r\n"
				+ "WHERE q.id_questionario = ?", BeanPropertyRowMapper.newInstance(Utente.class),questionario);
	}
	
	@Override
	public List<QuestionarioUtente> findQuestOfUser(int utente) {
		return jdbcTemplate.query("SELECT *\r\n"
				+ "FROM questionario_utente q\r\n"
				+ "WHERE q.id_utente = ?", BeanPropertyRowMapper.newInstance(QuestionarioUtente.class),utente);
	}
	
	@Override
	public Integer punteggioUtente(int utente,int questionario) {
		return jdbcTemplate.queryForObject("SELECT q.punteggio\r\n"
				+ "FROM questionario_utente q\r\n"
				+ "WHERE q.id_utente = ? AND q.id_questionario = ?",Integer.class,utente,questionario);
	}
	
	@Override
	public List<Questionario> TitoloDescrizion(int utente) {
		return jdbcTemplate.query("SELECT qu.titolo,qu.descrizione,qu.id\r\n"
				+ "FROM \r\n"
				+ "questionario qu INNER JOIN questionario_utente q\r\n"
				+ "ON q.id_questionario = qu.id\r\n"
				+ "WHERE q.id_utente = ?", BeanPropertyRowMapper.newInstance(Questionario.class),utente);
	}
	
	
	@Override
	public Integer QuestAlredyDone(int questionario, int utente) {
		return jdbcTemplate.queryForObject("SELECT u.punteggio\r\n"
				+ "FROM questionario_utente u\r\n"
				+ "WHERE u.id_questionario = ? AND u.id_utente = ?",Integer.class,questionario, utente);
	}
	
	@Override
	public void deleteQuest(int questionario, int utente) {
		 jdbcTemplate.update("DELETE FROM questionario_utente q\r\n"
				+ "WHERE q.id_questionario = ? AND q.id_utente = ?",questionario, utente);
	}
	
//------------RisposteUtente---------------------

	@Override
	public int saveRisposte(RisposteUtente r) {
		logger.debug("Repository: RisposteUtente {}",r);
		return jdbcTemplate.update("INSERT INTO risposte_utente(id,risposta,id_utente,id_questionario) VALUE(?,?,?,?)",new Object[] {r.getId(), r.getRisposta(), r.getId_utente(), r.getId_questionario()});
		
	}

	@Override
	public List<RisposteUtente> findAllRispo() {
		logger.debug("Repository:tutte le risposte");
		return jdbcTemplate.query("SELECT * FROM risposte_utente", BeanPropertyRowMapper.newInstance(RisposteUtente.class));
	}

	
	@Override
	public void deleteAllRispByQuestUtent(int id_questionario, int id_utente) {
		 jdbcTemplate.update("DELETE FROM risposte_utente r WHERE r.id_questionario = ? AND r.id_utente = ?",id_questionario, id_utente);
	}
	
	
}
