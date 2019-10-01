public interface Jogo {
    String getTitle();
    int getWidth();
    int getHeight();
    void tique(java.util.Set<String> teclas, double dt);
    void tecla(String tecla);
    void desenhar(Scene scene);
}