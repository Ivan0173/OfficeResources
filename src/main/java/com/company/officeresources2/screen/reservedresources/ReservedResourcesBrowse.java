package com.company.officeresources2.screen.reservedresources;

import com.company.officeresources2.app.ReservedResourcesService;
import io.jmix.core.LoadContext;
import io.jmix.ui.component.GroupTable;
import io.jmix.ui.component.data.GroupInfo;
import io.jmix.ui.screen.*;
import com.company.officeresources2.entity.ReservedResources;
import liquibase.repackaged.net.sf.jsqlparser.expression.operators.arithmetic.Concat;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

@UiController("ReservedResources.browse")
@UiDescriptor("reserved-resources-browse.xml")
@LookupComponent("reservedResourcesesTable")
public class ReservedResourcesBrowse extends StandardLookup<ReservedResources> {
    @Autowired
    ReservedResourcesService reservedResourcesService;
    @Autowired
    private GroupTable<ReservedResources> reservedResourcesesTable;

    //@Autowired
    //ReservedResources reservedResources;
    @Install(to = "reservedResourcesesDl", target = Target.DATA_LOADER)
    private List<ReservedResources> reservedResourcesesDlLoadDelegate(LoadContext<ReservedResources> loadContext) {

        List<ReservedResources> list = reservedResourcesService.loadShopAreas();
        return list;

    }

    private void setRowStyleInTable() {
        reservedResourcesesTable.setStyleProvider(new GroupTable.GroupStyleProvider<ReservedResources>() {
            @Nullable
            @Override
            public String getStyleName(ReservedResources entity, @Nullable String property) {
                if(!Objects.isNull(entity.getOwner())) {
                    return "cuatom-color";
                }
                return null;
            }
            @Nullable
            @Override
            public String getStyleName(GroupInfo info) {
                return null;
            }
        });
    }

    @Subscribe
    public void onAfterInit(AfterInitEvent event) {
        setRowStyleInTable();
    }


}