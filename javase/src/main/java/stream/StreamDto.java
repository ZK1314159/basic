package stream;

import lombok.Builder;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class StreamDto {

  private String url;

  private Integer id;

  public StreamDto increase() {
    StreamDto target = StreamDto.builder().build();
    BeanUtils.copyProperties(this, target);
    target.setId(id + 1);
    return target;
  }

  public StreamDto sum(StreamDto next) {
    id = id + next.getId();
    return this;
  }

  public static void main(String[] args) {
    List<StreamDto> influxdbList = new ArrayList<>();
    influxdbList.add(StreamDto.builder().id(1).build());
    influxdbList.add(StreamDto.builder().id(2).build());
    influxdbList.add(StreamDto.builder().id(3).build());
    influxdbList.add(StreamDto.builder().id(4).build());
    influxdbList = influxdbList.stream()
        .map(v -> {
          v.setId(v.getId() + 1);
          System.out.println("step 1");
          return v;
        })
        .map(v -> {
          v.setId(v.getId() + 1);
          System.out.println("step 2");
          return v;
        })
        .sorted((v1, v2) -> {
          System.out.println("step sort");
          return v1.getId().compareTo(v2.getId());
        })
        .map(v -> {
          v.setId(v.getId() + 1);
          System.out.println("step 3");
          return v;
        })
        .map(v -> {
          v.setId(v.getId() + 1);
          System.out.println("step 4");
          return v;
        })
        .filter( v -> {
          System.out.println("step filter");
          return v.getId() > 100;
        })
        .collect(Collectors.toList());

//    List<Integer> integers = new ArrayList<>();
//    integers.add(1);
//    integers.add(2);
//    integers.add(4);
//    Integer sum2 = integers.stream().reduce(0, Integer::sum);
//
//    List<BigDecimal> bigDecimals = new ArrayList<>();
//    bigDecimals.add(new BigDecimal("2.4"));
//    bigDecimals.add(new BigDecimal("2.9"));
//    bigDecimals.add(new BigDecimal("8.4"));
//    bigDecimals.add(new BigDecimal("2.6"));
//    BigDecimal bigDecimalSum = bigDecimals.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
  }

}
