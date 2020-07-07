import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

public class ReqApi {
	private HttpTransport TRANSPORT;
	private GenericUrl url;
	
	// Construtor <- URL da API
	public ReqApi(String url) {
		this.url = new GenericUrl(url);	
	}
	
	// Construtor <- atributo GenericUrl (sobrecarga)
	public ReqApi(GenericUrl genericUrl) {
		this.url = genericUrl;
	}
	
	/**
	 * Executa a requisicao com a URL informada.
	 * @return Retorna uma resposta HTTP
	 * @throws IOException
	 */
	public HttpResponse executar() throws IOException {
		return executar(new HashMap<String, String>());
	}
	
	/**
	 * Executa a requisicao com a URL informada, sendo necessario informar os parametros do cabecalho
	 * @param cabecalhos Lista mapeada contendo os parametros do cabecalho
	 * @return Resposta da requisicao HTTP
	 * @throws IOException
	 */
	public HttpResponse executar(Map<String, String> cabecalhos) throws IOException {
		HttpRequest requisicao = reqFactory().buildGetRequest(url);
		HttpHeaders cabecalho = new HttpHeaders();
		
		for(String chave : cabecalhos.keySet()) {
			//System.out.printf("Adicionado a chave %s com o valor %s\n", chave, cabecalhos.get(chave));
			cabecalho.set(chave, cabecalhos.get(chave));
		}
		
		requisicao.setHeaders(cabecalho);
		HttpResponse resposta = requisicao.execute();
		return resposta;
	}

	// Metodos obrigatorios para fazer a requisicao com a API (PADRAO)
	private HttpTransport transport() {
	    if (null == TRANSPORT) {
	        TRANSPORT = new NetHttpTransport();
	    }
	    return TRANSPORT;
	}
	
	private HttpRequestFactory REQ_FACTORY;
	 
	private HttpRequestFactory reqFactory() {
	    if (null == REQ_FACTORY) {
	        REQ_FACTORY = transport().createRequestFactory();
	    }
	    return REQ_FACTORY;
	}

}
