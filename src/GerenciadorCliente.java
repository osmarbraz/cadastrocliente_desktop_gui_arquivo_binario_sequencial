
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Realiza as operações no arquivo de cliente.
 *
 */
public class GerenciadorCliente {

    private String nomeArquivo;
    private RandomAccessFile arquivo;

    /**
     * Construtor sem parâmetro.
     *
     * Abre o arquivo com o nome default ao inicializar a classe.
     */
    public GerenciadorCliente() {
        //Nome do arquivo binário
        setNomeArquivo("CLIENTE.DAT");
        abrirArquivo();
    }

    /**
     * Construtor com parâmetro.
     *
     * Abre o arquivo com o nome especificado ao inicializar a classe.
     */
    public GerenciadorCliente(String nomeArquivo) {
        setNomeArquivo(nomeArquivo);
        abrirArquivo();
    }

    /**
     * Destrutor da classe. Fecha o arquivo.
     */
    public void finalize() {
        fecharArquivo();
    }

    // Get´s e Set´s
    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public RandomAccessFile getArquivo() {
        return arquivo;
    }

    public void setArquivo(RandomAccessFile arquivo) {
        this.arquivo = arquivo;
    }

    /**
     * Abre o arquivo.
     */
    public void abrirArquivo() {
        try {
            //Cria a referência externa ao objeto fileArquivo
            File fileArquivo = new File(getNomeArquivo());
            //Abre o arquivo para leitura e escrita
            arquivo = new RandomAccessFile(fileArquivo, "rw");
        } catch (IOException io) {
            System.out.println("Problemas ao manipular o arquivo: " + io);
        }
    }

    /**
     * Fecha a referência ao arquivo.
     */
    public void fecharArquivo() {
        try {
            //Fecha o arquivo
            arquivo.close();
        } catch (IOException io) {
            System.out.println("Problemas ao manipular o arquivo: " + io);
        }
    }

    /**
     * Inclui um registro no fim do arquivo.
     *
     * @param registro Registro de cliente a ser adicionado no fim do arquivo.
     * @return Retorna verdadeiro ou falso se conseguiu realizar a inclusão.
     */
    public boolean inserirFimArquivo(RegistroCliente registro) {
        try {
            //Posiciona o ponteiro de gravação no final do arquivo
            arquivo.seek(arquivo.length());
            //Escreve o registro no arquivo
            registro.escrita(arquivo);
            //Conseguiu realizar a inclusão
            return true;
        } catch (IOException io) {
            System.out.println("Problemas ao manipular o arquivo: " + io);
        }
        return false;
    }

    /**
     * Retorno o próximo código de cliente.
     *
     * Retorna o próximo código de cliente. Pocura pelo maior e incrementa em 1.
     *
     * @return Uma String com os dados do arquivo.
     */
    public int proximoCodigo() {
        //Retorna o próximo código disponível
        int proximo = -1;

        //Instancia um registro para armazenar os dados lido do arquivo.
        RegistroCliente registro = new RegistroCliente();
        try {
            if (getArquivo().length() > 0) {
                arquivo.seek(0);
                //Enquanto o ponteiro de leitura for menor que o tamanho do arquivo
                while (getArquivo().getFilePointer() < getArquivo().length()) {
                    //Realiza a leitura de um registro do arquivo
                    registro.leitura(arquivo);
                    //Procura o maior
                    if (registro.getCodigo() > proximo) {
                        proximo = registro.getCodigo();
                    }
                }
            } else {
                //Primeiro código de cliente
                proximo = 0;
            }
        } catch (EOFException eof) {
            System.out.println("Chegou ao final do arquivo: " + eof);
        } catch (IOException io) {
            System.out.println("Problemas ao manipular o arquivo: " + io);
        }

        //Incrementa o proximo código.
        return proximo + 1;
    }

    /**
     * Realiza o retorno dos dados não excluídos do arquivo.
     *
     * Retorna os dados do arquivo onde o campo chave é diferente de -1.
     *
     * @return Uma String com os dados do arquivo.
     */
    public String listarLogico() {
        String linha = "";
        //Instancia um registro para armazenar os dados lido do arquivo.
        RegistroCliente registro = new RegistroCliente();
        try {
            //Posiciona no início do arquivo
            arquivo.seek(0);
            //Enquanto o ponteiro de leitura for menor que o tamanho do arquivo
            while (getArquivo().getFilePointer() < getArquivo().length()) {
                //Realiza a leitura de um registro do arquivo
                registro.leitura(arquivo);
                //Concatena somente valores chave diferente de -1
                if (registro.getCodigo() != -1) {
                    //Concatena os dados do registro
                    linha = linha + registro.paraString() + "\n";
                }
            }
        } catch (EOFException eof) {
            System.out.println("Chegou ao final do arquivo: " + eof);
        } catch (IOException io) {
            System.out.println("Problemas ao manipular o arquivo: " + io);
        }
        return linha;
    }

    /**
     * Realiza o retorno dos dados do arquivo.
     *
     * Retorna todos os dados do arquivo inclusive os excluídos.
     *
     * @return Uma String com os dados do arquivo.
     */
    public String listarFisico() {
        //Variável para concatenar os dados
        String linha = "";
        //Instancia um registro para armazenar os dados lido do arquivo.
        RegistroCliente registro = new RegistroCliente();
        try {
            arquivo.seek(0);
            //Enquanto o ponteiro de leitura for menor que o tamanho do arquivo
            while (getArquivo().getFilePointer() < getArquivo().length()) {
                //Realiza a leitura de um registro do arquivo
                registro.leitura(arquivo);
                //Concatena os dados do registro
                linha = linha + registro.toString() + "\n";
            }
        } catch (EOFException eof) {
            System.out.println("Chegou ao final do arquivo: " + eof);
        } catch (IOException io) {
            System.out.println("Problemas ao manipular o arquivo: " + io);
        }
        return linha;
    }

    /**
     * Retorna a quantidade de registros.
     *
     * @return Um número inteiro com a quantidade de registros.
     */
    public int getQuantidadeRegistro() {
        int contador = 0;
        try {
            //Instancia um registro para armazenar os dados lido do arquivo.
            RegistroCliente registro = new RegistroCliente();
            //Posiciono no início do arquivo.
            arquivo.seek(0);
            //Enquanto o ponteiro de leitura for menor que o tamanho do arquivo.
            while (getArquivo().getFilePointer() < getArquivo().length()) {
                //Realiza a leitura de um registro do arquivo
                registro.leitura(arquivo);
                //Somente para os registros não apagados                
                if (registro.getCodigo() != -1) {
                    //Incrementa o contador de registro.
                    contador = contador + 1;
                }
            }
        } catch (IOException io) {
            System.out.println("Problemas ao manipular o arquivo: " + io);
        }
        return contador;
    }

    /**
     * Recupera as informações do arquivo.
     *
     * @return Uma string com os dados do arquivo.
     */
    public String informacoes() {
        String informacoes = "";
        try {
            //Concatena as informações do arquivo
            RegistroCliente cliente = new RegistroCliente();
            informacoes = "Tamanho do Arquivo : " + arquivo.length() + " Kb "
                    + "\n Número de Registros : " + getQuantidadeRegistro()
                    + "\nCada regitro possui : " + cliente.getTamanhoRegistro() + " Kb ";
        } catch (IOException io) {
            System.out.println("Problemas ao manipular o arquivo: " + io);
        }
        return informacoes;
    }

    /**
     * Atualiza um registro no arquivo com base na chave.
     *
     * @param chave Chave do registro a ser atualizado.
     * @param cliente Um cliente com os novos dados.
     *
     * @return Retorna verdadeiro ou falso se conseguiu atualizar o registro.
     */
    public boolean atualizarArquivo(int chave, RegistroCliente cliente) {
        try {
            //Pega a posição do registro com a chave a ser alterada
            int posicao = posicaoRegistro(chave);
            if (posicao != -1) {
                //Atribui o novo registro a ser salvo
                RegistroCliente registro = cliente;
                //Posiciona na posição do registro a ser alterado
                arquivo.seek(posicao * registro.getTamanhoRegistro());
                //Escreve o registro no arquivo
                registro.escrita(arquivo);
                return true;

            } else {
                return false;
            }
        } catch (EOFException eof) {
            System.out.println("Chegou ao final do arquivo: " + eof);
        } catch (IOException io) {
            System.out.println("Problemas ao manipular o arquivo: " + io);
        }
        return false;
    }

    /**
     * Retorna a posição de um registro no arquivo.
     *
     * @param chave Valor a ser procurado.
     *
     * @return Um valor com a posição do registro que tem a chave. Se não
     * encontrar posição retorna -1.
     */
    public int posicaoRegistro(int chave) {
        //Guarda a posição da parada da procura
        int posicao = -1;
        //Instancia um registro para armazenar os dados lido do arquivo.
        RegistroCliente registro = new RegistroCliente();
        try {
            //Posiciona no início do arquivo
            arquivo.seek(0);
            //Utilizado para interroper o laço da leitura do arquivo
            boolean achei = false;
            //Enquanto o ponteiro de leitura for menor que o tamanho do arquivo e não achei
            while ((getArquivo().getFilePointer() < getArquivo().length()) && (achei == false)) {
                //Realiza a leitura de um registro do arquivo
                registro.leitura(arquivo);
                //Vefifica se é igual a chave
                if (registro.getCodigo() == chave) {
                    achei = true;
                }
                //Incrementa o contador de posições
                posicao = posicao + 1;
            }
            //Verifica se achou
            if (achei == true) {
                //Retorna a posição encontrada
                return posicao;
            } else {
                //Não conseguiu encontrar o registro
                return -1;
            }
        } catch (EOFException eof) {
            System.out.println("Chegou ao final do arquivo: " + eof);
        } catch (IOException io) {
            System.out.println("Problemas ao manipular o arquivo: " + io);
        }
        return posicao;
    }

    /**
     * Exclui lógicamente um registro do arquivo.
     *
     * Atribui -1 para o campo chave do registro.
     *
     * @param chave Chave do registro a ser excluído.
     *
     * @return Verdadeiro ou falso se conseguiu excluir logicamente o registro.
     */
    public boolean excluirLogico(int chave) {
        //Guarda a posição da parada da procura
        int posicao = -1;
        //Instancia um registro para armazenar os dados lido do arquivo.
        RegistroCliente registro = new RegistroCliente();
        try {
            //posiciona no inicio do arquivo
            arquivo.seek(0);
            //Utilizado para interroper o laço da leitura do arquivo
            boolean achei = false;
            //Enquanto o ponteiro de leitura for menor que o tamanho do arquivo e não achei
            while ((getArquivo().getFilePointer() < getArquivo().length()) && (achei == false)) {
                registro.leitura(arquivo);
                //Encerra a procura se encontrei a chave
                if (registro.getCodigo() == chave) {
                    achei = true;
                }
                //Incrementa o contador de posições
                posicao = posicao + 1;
            }
            //Se encontrou o registro realiza a exclusão
            if (achei == true) {
                //Altera o registro a ser excluído
                registro.setCodigo(-1);
                ////Posiciona no registro a ser alterado
                arquivo.seek(posicao * registro.getTamanhoRegistro());
                //Escreve o registro alterado no arquivo
                registro.escrita(arquivo);
                return true;
            } else {
                //Não conseguiu encontrar o registro
                return false;
            }
        } catch (EOFException eof) {
            System.out.println("Chegou ao final do arquivo: " + eof);
        } catch (IOException io) {
            System.out.println("Problemas ao manipular o arquivo: " + io);
        }
        return false;
    }

    /**
     * Excluí fisicamente um registro do arquivo.
     *
     * Cria um arquivo temporário para receber os registros menos o que deve ser
     * excluído. Apaga o arquivo principal e renomeia o arquivo temporário para
     * principal.
     *
     * @param chave Valor da chave do registro a ser excluído.
     *
     * @return Verdadeiro ou falso se conseguiu excluir fisicamente o registro.
     */
    public boolean excluirFisico(int chave) {
        //Instancia um registro para armazenar os dados lido do arquivo.
        RegistroCliente registro = new RegistroCliente();
        try {
            //Copia os dados do arquivo principal para o arquivo temporário

            //Retorna o nome do arquivo até o ponto
            String nomeArquivoTemp = getNomeArquivo().substring(0, getNomeArquivo().indexOf("."));
            //Adiciona a extensão tmp ao nome do arquivo temporpario
            nomeArquivoTemp = nomeArquivoTemp + ".TMP";
            //Cria a referência ao arquivo temporário
            File fileArquivoTemp = new File(nomeArquivoTemp);
            //Abre o arquivo temporário para leitura e escrita
            RandomAccessFile arquivoTemp = new RandomAccessFile(fileArquivoTemp, "rw");
            //Esvazia o arquivo temporário 
            arquivoTemp.setLength(0);
            try {
                //Posiciona o arquivos dos dados no inicio
                arquivo.seek(0);
                //Copia todos os registro do arquivo para um arquivo temporário, menos o registro a ser excluído                
                //Enquanto o ponteiro de leitura for menor que o tamanho do arquivo
                while ((getArquivo().getFilePointer() < getArquivo().length())) {
                    //Realiza a leitura do registro
                    registro.leitura(arquivo);
                    //Utiliza somente valores chave diferente de -1
                    if (registro.getCodigo() != -1) {
                        //Copia todos os registros menos a chave
                        if (registro.getCodigo() != chave) {
                            //Posiciona o arquivo temporário no final
                            arquivoTemp.seek(arquivoTemp.length());
                            //Escreve o registro no arquivo temporário
                            registro.escrita(arquivoTemp);
                        }
                    }
                }
            } catch (EOFException eof) {
                System.out.println("Chegou ao final do arquivo: " + eof);
            } catch (IOException io) {
                System.out.println("Problemas ao manipular o arquivo: " + io);
            }

            //Copia os dados do arquivo temporário para o arquivo principal
            // Apaga o arquivo original
            arquivo.setLength(0);
            try {
                //Posiciona no início do arquivo
                arquivoTemp.seek(0);
                //Enquanto o ponteiro de leitura for menor que o tamanho do arquivo
                while ((arquivoTemp.getFilePointer() < arquivoTemp.length())) {
                    //Realiza a leitura de um registro do arquivo temporário
                    registro.leitura(arquivoTemp);
                    //Posiciona no final do arquivo
                    arquivo.seek(arquivo.length());
                    //Escreve um registro no arquivo
                    registro.escrita(arquivo);
                }
            } catch (EOFException eof) {
                System.out.println("Chegou ao final do arquivo: " + eof);
            } catch (IOException io) {
                System.out.println("Problemas ao manipular o arquivo: " + io);
            }
            // Apaga o temporario
            arquivoTemp.setLength(0);
            // Fecha o arquivo temporário
            arquivoTemp.close();
            // Apaga o arquivo temporário
            fileArquivoTemp.delete();
            return true;
        } catch (EOFException eof) {
            System.out.println("Chegou ao final do arquivo: " + eof);
        } catch (IOException io) {
            System.out.println("Problemas ao manipular o arquivo: " + io);
        }
        return false;
    }

    /**
     * Pesquisa uma chave no arquivo retornando o registro.
     *
     * @param chave Valor chave a se pesquisado no arquivo.
     *
     * @return Retorna o registro encontrado no arquivo.
     */
    public RegistroCliente pesquisarRegistro(int chave) {
        //Objeto de retorno do método
        RegistroCliente retorno = null;
        //Registro a ser utilizado para ler o arquivo
        RegistroCliente registro = new RegistroCliente();
        try {
            //Posiciona no início do arquivo
            arquivo.seek(0);
            //Utilizado para interroper o laço da leitura do arquivo
            boolean achei = false;
            //Realiza a leitura do primeiro registro do arquivo
            registro.leitura(arquivo);
            //Enquanto o ponteiro de leitura for menor que o tamanho do arquivo ou diferente da chave
            while ((getArquivo().getFilePointer() < getArquivo().length()) && (achei == false)) {
                //Realiza a leitura de um registro do arquivo
                registro.leitura(arquivo);
                //Encerra a procura se encontrei a chave
                if (registro.getCodigo() == chave) {
                    achei = true;
                }
            }
            //Verifica se é igual a chave
            if (achei == true) {
                //retorna o registro encontrado
                return registro;
            } else {
                //retorna o registro de não encontrado
                return retorno;
            }
        } catch (EOFException eof) {
            System.out.println("Chegou ao final do arquivo: " + eof);
        } catch (IOException io) {
            System.out.println("Problemas ao manipular o arquivo: " + io);
        }
        return retorno;
    }

    /**
     * Pesquisa um nome no arquivo retornando o registro.
     *
     * @param chave Valor chave a se pesquisado no arquivo.
     *
     * @return Retorna o registro encontrado no arquivo.
     */
    public RegistroCliente pesquisarRegistroNome(String chave) {
        //Objeto de retorno do método
        RegistroCliente retorno = null;
        //Registro a ser utilizado para ler o arquivo
        RegistroCliente registro = new RegistroCliente();
        try {
            //Posiciona no início do arquivo
            arquivo.seek(0);
            //Utilizado para interroper o laço da leitura do arquivo
            boolean achei = false;
            //Realiza a leitura do primeiro registro do arquivo
            registro.leitura(arquivo);
            //Enquanto o ponteiro de leitura for menor que o tamanho do arquivo ou diferente da chave
            while ((getArquivo().getFilePointer() < getArquivo().length()) && (achei == false)) {
                //Realiza a leitura de um registro do arquivo
                registro.leitura(arquivo);
                //Encerra a procura se encontrei a chave
                if (registro.getNome().equals(chave)) {
                    achei = true;
                }
            }
            //Verifica se é igual a chave
            if (achei == true) {
                //retorna o registro encontrado
                return registro;
            } else {
                //retorna o registro de não encontrado
                return retorno;
            }
        } catch (EOFException eof) {
            System.out.println("Chegou ao final do arquivo: " + eof);
        } catch (IOException io) {
            System.out.println("Problemas ao manipular o arquivo: " + io);
        }
        return retorno;
    }

    /**
     * Apaga os registro do arquivo.
     *
     * @return Se conseguiu esvaziar o arquivo.
     */
    public boolean zeraArquivo() {
        try {
            //Seta o tamanho do arquivo em 0.
            arquivo.setLength(0);
            return true;
        } catch (IOException io) {
            System.out.println("Problemas ao manipular o arquivo: " + io);
            return false;
        }
    }
}
