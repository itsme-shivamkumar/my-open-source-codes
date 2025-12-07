import java.util.*;

class RecordExample {
  public record CustomDto(int id, String name, int age){
    // Custom Constructor
    public CustomDto(int id, int age){
      this(id, "Default Name", age);
    }
    // Custom Getter
    public int getId() {
      return id();
    }
  };
    public static void main(String[] args) {
        CustomDto dto = new CustomDto(1,"Shivam", 25);
        System.out.println(dto);
        CustomDto customDto = new CustomDto(2, 26);
        System.out.println(customDto);
        // id(), name(), age() are Default Getters
        System.out.println("Default getter -> " + customDto.id() + " , custom getter -> " 
          + customDto.getId());
        // Setter on Record will giver compilation error
        // customDto.id(3);
    }
}