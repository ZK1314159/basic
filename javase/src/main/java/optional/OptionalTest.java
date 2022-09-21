package optional;

import lombok.Data;

import java.util.Optional;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/9/22 00:13 <br>
 */
@Data
public class OptionalTest {

  private Integer id;

  private Inner inner;

  @Data
  public static class Inner {
    private Integer id1;
    private Inner1 inner1;
    public Inner(Integer id1) {
      this.id1 = id1;
    }
  }

  @Data
  public static class Inner1 {
    private Integer id2;
    private String url;
    public Inner1(Integer id2) {
      this.id2 = id2;
    }
  }

  public static void main(String[] args) {
    OptionalTest optionalTest = new OptionalTest();
    optionalTest.setId(2);
//    optionalTest.setInner(new Inner(3));
    Inner1 inner1 = Optional.of(optionalTest)
        .map(v -> {
          System.out.println("step 1");
          return v.getInner();
        })
        .map(v -> {
          System.out.println("step 2");
          return v.getInner1();
        })
        .orElse(new Inner1(3));
  }

}
