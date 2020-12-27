package com.erin.base.dto.request.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

@Data
public class SysMenuPageQuery extends Page {

    String menuName;

    String menuCode;

}
