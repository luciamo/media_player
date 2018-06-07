package application;

public class User {
	
	private String userName;
	private String password;
	
	/**
	 * M�todo construtor da classe
	 * @param userName: o nome do usuario, usado no login 
	 * @param password: a senha do usuario
	 */
	User(String userName, String password){
		this.userName = userName;
		this.password = password;
	}
	
	/**
	 * M�todo para acessar o nome do usuario
	 * @return userName: o nome do usuario
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * M�todo para comparar se a senha esta correta
	 * @param password: senha usada para fazer o login
	 * @return true: se a senha estiver correta
	 */
	public boolean comparePassword(String password) {
		return this.password.equals(password);
	}

	
}
