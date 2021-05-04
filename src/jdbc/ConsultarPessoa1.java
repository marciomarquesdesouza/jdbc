package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConsultarPessoa1 {

	public static void main(String[] args) throws SQLException {
		
		Connection connection = FabricaConexao.getConexao();
		String sql = "SELECT * FROM pessoas";
		
		Statement stmt = connection.createStatement();
		ResultSet result = stmt.executeQuery(sql);
		
		List<Pessoa> pessoas = new ArrayList<>();
		
		while(result.next()) {
			int code = result.getInt("codigo");
			String nome = result.getString("nome");
			pessoas.add(new Pessoa(code, nome));
		}
		
		for(Pessoa p: pessoas) {
			System.out.println(p.getCodigo() + " ==> " + p.getNome());
		}
		
		stmt.close();
		connection.close();
	}
}
