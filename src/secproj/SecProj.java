/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secproj;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.TreeMap;
/**
 *
 * @author leonardo
 */
public class SecProj {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Cálculo tarefa: ((596534 + 615707) % 3) > "
                + " Tarefa nº " + ((596534 + 615707) % 3) + "\n");

        ArquivoLeitura log = new ArquivoLeitura("game-reviews.csv");
        String linha = log.lerLinha();
        linha = log.lerLinha(); //deve-se pular a primeira linha pois ela contem o cabecalho
        String[] rowTable;

        TreeMap<String, Item> tableOne = new TreeMap();

        Item item;
        while (linha != null) {
            rowTable = linha.split(";");
            item = new Item();
            int colTable = 1;

            if (tableOne.containsKey(rowTable[colTable])) {
                //pega o item do dicionario
                item = tableOne.get(rowTable[colTable]);
            }
            //coloca o item no dicionario
            tableOne.put(rowTable[colTable], popular(item, rowTable));
            linha = log.lerLinha();
        }
        log.fechar();

        totalReviewsPorPlataforma(tableOne);
        percentCriterioPorPlataforma(tableOne, "Great");
        mediaScorePorPlataforma(tableOne);

    }
    
    public static Item popular(Item i, String[] array) {
        Jogo jogo = new Jogo();
        //preenche a classe com a nova linha
        jogo.setReview(array[2]);
        jogo.setTitulo(array[0]);
        jogo.setGenero(array[4]);
        jogo.setPlatform(array[1]);
        jogo.setScore(Double.parseDouble(array[3]));
        if (i.getBest() == null) {
            i.setBest(jogo);
        } else {
            if (i.getBest().getScore() <= jogo.getScore()) {
                i.setBest(jogo);
            }
        }
        if (i.getWorst() == null) {
            i.setWorst(jogo);
        } else {
            if (i.getWorst().getScore() >= jogo.getScore()) {
                i.setWorst(jogo);
            }
        }
        //insere o jogo dentro do item
        i.setInfos(jogo);
        return i;
    }

    public static void totalReviewsPorPlataforma(TreeMap<String, Item> table) {
        System.out.println("\n\tNumero de reviews por plataforma\n");
        int cont = 0;
        for (String k : table.keySet()) {
            cont++;
            System.out.println(cont + "\t" + k + " = " + table.get(k).getInfos().size());
        }
    }

    public static void percentCriterioPorPlataforma(TreeMap<String, Item> table, String criterio) {
        System.out.println("\n\tPercentual de avaliações '" + criterio + "' por plataforma\n");
        int cont;
        int contTotal = 0;
        for (String k : table.keySet()) {
            cont = 0;
            for (int i = 0; i < table.get(k).getInfos().size(); i++) {
                if (table.get(k).getInfos().get(i).getReview().equals(criterio)) {
                    cont++;
                }
            }
            contTotal++;
            Double percent = (cont * (100.0 / table.get(k).getInfos().size()));
            DecimalFormat formato = new DecimalFormat("#");
            percent = Double.valueOf(formato.format(percent));

            System.out.println(contTotal + "\t" + k + " = " + percent + "%");
        }
    }

    public static void mediaScorePorPlataforma(TreeMap<String, Item> table) {
        System.out.println("\n\tMédia de score por plataforma\n");
        int cont;
        int contTotal = 0;
        Double score;
        Double media;
        for (String k : table.keySet()) {
            cont = 0;
            score = 0.0;
            for (int i = 0; i < table.get(k).getInfos().size(); i++) {
                score += table.get(k).getInfos().get(i).getScore();
                cont++;
            }
            media = score / cont;
            contTotal++;
            DecimalFormat scorePlatform = new DecimalFormat("#,##");
            media = Double.valueOf(scorePlatform.format(media));

            System.out.println(contTotal + "\t" + k + " = " + media);
        }
    }
    
}
