package br.ufc.crateus.aps.times;

import java.util.LinkedList;

public class Games {

    public Games(int numTeams, int numMatches) {
        this.numMatches = numMatches;
        this.numTeams = numTeams;
    }

    private LinkedList<Teams> list = new LinkedList<>();
    private int numMatches;
    private int numTeams;

    private int count;

    public void put(String name, int points) {

        name = name.replaceAll("[á,Á,ã,Ã,ä,Ä,à,À,â,Â]", "a").
                replaceAll("[é,É,ë,Ë,ẽ,Ẽ,ê,Ê]", "e").
                replaceAll("[í,Í]", "i").
                replaceAll("[ó,Ó,ò,ò,ö,Ö,õ,Õ,ô,Ô]", "o").
                replaceAll("[ú,Ú,ù,ù,ü,Ü]", "u").
                replaceAll("[ç,Ç]", "c");

        if (this.numTeams >= 2 && this.numTeams <= 200 && this.numMatches >= 0) {

            if (name.length() <= 10 && count <= this.numMatches) {

                Teams newTeam = new Teams(name, points);
                list.add(newTeam);

                count++;
            } else {
                System.out.println("verifique se o nome tem menos de 10 caracteres ou se o número de partidas já extrapolou! ");
            }
        } else {
            System.out.println("numero de equipes desrepeita as regras!!");
        }
    }

    public int checkDraws() {

        int acc = 0;
        for (Teams ob : list) {
            acc += countLoserPoints(ob);
        }

        if (sumPoints() > (this.numMatches * 3)) {
            System.out.println("a pontuação das equipes não é possível visto o numero de jogos ");
            return - 1;
        }

        return acc % (this.numMatches * 3);
    }

    private int sumPoints() {
        int acc = 0;
        for (Teams p : list) {
            acc += p.getPoints();
        }
        return acc;
    }

    private int countLoserPoints(Teams t) {
        return (this.numMatches * 3) - t.getPoints();
    }

    public int getNumMatches() {
        return this.numMatches;
    }

    public int getNumTeams() {
        return this.numTeams;
    }

    @Override
    public String toString() {
        return list.toString();
    }

}
