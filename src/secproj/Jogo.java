package secproj;

public class Jogo {
    
    private String review;
    private String titulo;
    private String platform;
    private String genero;
    private Double score;
//    private String release;

    public Jogo(String titulo, String platform, Double score/*, String release*/) {
        this.titulo = titulo;
        this.platform = platform;
        this.score = score;
//        this.release = release;
    }

    public Jogo() {
    
    }
    
    public Jogo(Jogo game) {
        all(game);
    }
    
    private void all(Jogo game) {
        this.titulo = game.getTitulo();
        this.platform = game.getPlatform();
        this.score = game.getScore();
//        this.release = game.getRelease();
    }

//    public String getRelease() {
//        return release;
//    }
//
//    public void setRelease(String year, String month, String day) {
//        
//        //  formatoDD/MM/YYYY
//
//        this.release = day + "/" + month + "/" + year;
//    
//    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
  
    public void setPosicaoScore(char sinal, Jogo game){
        if(sinal == '+'){
            
            if(game.getScore() > this.getScore()){
                this.all(game);
            }
            
        } else if ( sinal == '-' ) {
            
            if(game.getScore() < this.getScore()){
                this.all(game);
            }
            
        } else {
            System.out.println("Sinal Inválido!");
        }
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }
    
}
