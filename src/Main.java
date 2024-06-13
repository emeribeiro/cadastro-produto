import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int id = 1;
        List<Produto> produtos = new ArrayList<>();
        id = carregarProdutos(id, produtos);
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            menu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    listarProdutos(produtos);
                    break;

                case 2:
                    cadastrarProduto(scanner, id, produtos);
                    break;

                case 3:
                    editarProduto(scanner, produtos);
                    break;

                case 4:
                    deletarProduto(scanner, produtos);
                    break;
            }

        } while (opcao != 5);
        scanner.close();
    }

    private static int carregarProdutos(int id, List<Produto> produtos) {
        Produto produto = new Produto(id++, "IPHONE 13 PRO", 8, 5000);
        Produto produto2 = new Produto(id++, "MACBOOK", 1, 1000);
        return id;
    }

    private static void menu() {
        System.out.println(
                "\n1 - Listar produtos\n" +
                        "2 - Cadastrar novo produto\n" +
                        "3 - Editar produto\n" +
                        "4 - Excluir produto\n" +
                        "5 - Sair"
        );
        System.out.println("DIGITE UMA OPÇÃO");
    }

    private static void listarProdutos(List<Produto> produtos) {
        System.out.println(
                "--------------------------------------------------------------------------");
        System.out.printf("%5s %20s %20s %20s\n", "ID", "NOME", "VALOR", "QUANTIDADE");
        System.out.println(
                "--------------------------------------------------------------------------");

        produtos.forEach(produtoMenu ->
                System.out.printf("%5d %20s %20d %20d\n",
                        produtoMenu.getId(),
                        produtoMenu.getNome(),
                        produtoMenu.getValor(),
                        produtoMenu.getQuantidade()
                ));

        System.out.println(
                "--------------------------------------------------------------------------");
    }

    private static void cadastrarProduto(Scanner scanner, int id, List<Produto> produtos) {
        Produto produtoCadastro= new Produto();

        System.out.println("DIGITE O NOME DO PRODUTO");
        String nome = scanner.next();
        produtoCadastro.setId(id++);
        produtoCadastro.setNome(nome);

        System.out.println("DIGITE O VALOR DO PRODUTO");
        Integer valor = scanner.nextInt();
        produtoCadastro.setValor(valor);

        System.out.println("DIGITE A QUANTIDADE DO PRODUTO");
        Integer quantidade = scanner.nextInt();
        produtoCadastro.setQuantidade(quantidade);

        produtos.add(produtoCadastro);

        System.out.println("PRODUTO SALVO!");
    }

    private static void editarProduto(Scanner scanner, List<Produto> produtos) {
        System.out.println("DIGITE O ID DO PRODUTO");
        Integer idEdit = scanner.nextInt();

        for (Produto produtoEdit : produtos) {
            if (produtoEdit.getId().equals(idEdit)) {

                System.out.println("DIGITE O NOME DO PRODUTO");
                String nomeEdit = scanner.next();
                produtoEdit.setNome(nomeEdit);

                System.out.println("DIGITE O VALOR DO PRODUTO");
                Integer valorEdit = scanner.nextInt();
                produtoEdit.setValor(valorEdit);

                System.out.println("DIGITE A QUANTIDADE DO PRODUTO");
                Integer quantidadeEdit = scanner.nextInt();
                produtoEdit.setQuantidade(quantidadeEdit);

                System.out.println("PRODUTO EDITADO COM SUCESSO!");
                break;
            }
        }
    }

    private static void deletarProduto(Scanner scanner, List<Produto> produtos) {
        System.out.println("DIGITE O ID DO PRODUTO");
        Integer idDel = scanner.nextInt();

        for (Produto produtoDel : produtos) {
            if (produtoDel.getId().equals(idDel)) {
                produtos.remove(produtoDel);
                System.out.println("PRODUTO DELETADO COM SUCESSO!");
                break;
            }
        }
    }
}
