public class User {

  private String password;
  private String salt;
  private String hash;

  public User(String startPassword){
    password = startPassword;
  }

  public getPassword(){
    return password;
  }

  public setPassword(String newValue){
    password = newValue;
  }

  public getSalt(){
    return salt;
  }

  public setSalt(String newValue){
    salt = newValue;
  }

  public getHash(){
    return hash;
  }

  public setHash(String newValue){
    hash = newValue;
  }
}
