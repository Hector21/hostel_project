<<<<<<< Updated upstream
package war.webapp.dao;

import war.webapp.model.DutyRemark;

public interface RemarkDao extends GenericDao<DutyRemark, Long> {
}
=======
package war.webapp.dao;

import war.webapp.model.DutyRemark;

public interface RemarkDao extends GenericDao<DutyRemark, Long> {
    public DutyRemark saveDutyRemark(DutyRemark dutyRemark);
}
>>>>>>> Stashed changes
