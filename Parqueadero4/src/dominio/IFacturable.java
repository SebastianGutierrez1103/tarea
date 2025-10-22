package dominio;

public interface IFacturable {

    public abstract String getType();

    public abstract double getRecargo();

    public abstract double getTarifa();

    public abstract String getPlaca();

}
