/**
 * Sistema de boletim escolar.
 *
 * Calcula a média final de um aluno a partir de duas notas
 * e apresenta a situação correspondente (aprovado ou reprovado).
 */
import java.util.Locale;

public class Sistema {

    /** Média mínima exigida para que o aluno seja aprovado. */
    private static final double MEDIA_MINIMA_APROVACAO = 6.0;

    private static final String SITUACAO_APROVADO = "Aprovado";
    private static final String SITUACAO_REPROVADO = "Reprovado";

    public static void main(String[] args) {
        String nomeDoAluno = "Carlos";
        double primeiraNota = 8.0;
        double segundaNota = 7.0;

        double mediaFinal = calcularMedia(primeiraNota, segundaNota);
        String situacaoDoAluno = verificarSituacao(mediaFinal);

        apresentarResultado(nomeDoAluno, mediaFinal, situacaoDoAluno);
    }

    /**
     * Calcula a média aritmética simples entre as duas notas do aluno.
     */
    private static double calcularMedia(double primeiraNota, double segundaNota) {
        return (primeiraNota + segundaNota) / 2;
    }

    /**
     * Determina a situação do aluno comparando a média final
     * com a média mínima de aprovação.
     */
    private static String verificarSituacao(double mediaFinal) {
        if (mediaFinal >= MEDIA_MINIMA_APROVACAO) {
            return SITUACAO_APROVADO;
        }
        return SITUACAO_REPROVADO;
    }

    /**
     * Exibe o resultado do aluno formatado para o usuário.
     */
    private static void apresentarResultado(String nomeDoAluno, double mediaFinal, String situacao) {
        System.out.println("Aluno: " + nomeDoAluno);
        System.out.printf(Locale.US, "Média: %.1f%n", mediaFinal);
        System.out.println("Situação: " + situacao);
    }
}
