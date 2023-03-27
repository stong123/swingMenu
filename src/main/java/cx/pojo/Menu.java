package cx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    //菜单ID
    private String id;
    //菜单名称
    private String name;
    //上级菜单ID
    private String pId;
    //下级菜单集合
    private List<Menu> children;
}