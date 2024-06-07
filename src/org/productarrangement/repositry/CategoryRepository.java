package org.productarrangement.repositry;

import org.productarrangment.config.*;
import org.productarrangment.model.*;
import java.sql.*;

public class CategoryRepository extends DBconfig {
	public boolean addNewCategory(CategoryModel cModel) {
        try {
            PreparedStatement stmt = conn.prepareStatement("insert into category values ('0',?)");
            stmt.setString(1, cModel.getCategoryname());
            int value = stmt.executeUpdate();
            return value > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
	
}
