package personal.model;

public class UserMapper {
    public String map(User user) {
        return String.format("%s;%s;%s;%s;%s", user.getId(), user.getFirstName(), user.getLastName(), user.getPhone(), user.getCheck());
    }

    public String mapToComma (User user) {
        return String.format("%s,%s,%s,%s,%s", user.getId(), user.getFirstName(), user.getLastName(), user.getPhone(), user.getCheck());
    }

    public User map(String line) {
        String[] lines = line.split("[;]");
        return new User(lines[0], lines[1], lines[2], lines[3], lines[4]);
    }

    public User mapToComma(String line) {
//        if(line.equals("")){
//            return new User();
//        }
        String[] lines = line.split("[,;]");
        return new User(lines[0], lines[1], lines[2], lines[3], lines[4]);

    }
}
