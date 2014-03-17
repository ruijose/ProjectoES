package pt.ist.rest.domain;

import pt.ist.fenixframework.pstm.VBox;
import pt.ist.fenixframework.pstm.RelationList;
import pt.ist.fenixframework.pstm.OJBFunctionalSetWrapper;
import pt.ist.fenixframework.ValueTypeSerializationGenerator.*;
public abstract class Alimento_Base extends pt.ist.fenixframework.pstm.OneBoxDomainObject {
    public final static pt.ist.fenixframework.pstm.dml.RoleOne<pt.ist.rest.domain.Alimento,pt.ist.rest.domain.Prato> role$$prato = new pt.ist.fenixframework.pstm.dml.RoleOne<pt.ist.rest.domain.Alimento,pt.ist.rest.domain.Prato>() {
        public pt.ist.rest.domain.Prato getValue(pt.ist.rest.domain.Alimento o1) {
            return ((Alimento_Base.DO_State)o1.get$obj$state(false)).prato;
        }
        public void setValue(pt.ist.rest.domain.Alimento o1, pt.ist.rest.domain.Prato o2) {
            ((Alimento_Base.DO_State)o1.get$obj$state(true)).prato = o2;
        }
        public dml.runtime.Role<pt.ist.rest.domain.Prato,pt.ist.rest.domain.Alimento> getInverseRole() {
            return pt.ist.rest.domain.Prato.role$$alimento;
        }
        
    };
    public final static pt.ist.fenixframework.pstm.LoggingRelation<pt.ist.rest.domain.Alimento,pt.ist.rest.domain.Prato> PratoContainsAlimentos = new pt.ist.fenixframework.pstm.LoggingRelation<pt.ist.rest.domain.Alimento,pt.ist.rest.domain.Prato>(role$$prato);
    static {
        pt.ist.rest.domain.Prato.PratoContainsAlimentos = PratoContainsAlimentos.getInverseRelation();
    }
    
    static {
        PratoContainsAlimentos.setRelationName("pt.ist.rest.domain.Alimento.PratoContainsAlimentos");
    }
    
    
    
    
    private void initInstance() {
        initInstance(true);
    }
    
    private void initInstance(boolean allocateOnly) {
        
    }
    
    {
        initInstance(false);
    }
    
    protected  Alimento_Base() {
        super();
    }
    
    public java.lang.String getTipo() {
        pt.ist.fenixframework.pstm.DataAccessPatterns.noteGetAccess(this, "tipo");
        return ((DO_State)this.get$obj$state(false)).tipo;
    }
    
    public void setTipo(java.lang.String tipo) {
        ((DO_State)this.get$obj$state(true)).tipo = tipo;
    }
    
    private java.lang.String get$tipo() {
        java.lang.String value = ((DO_State)this.get$obj$state(false)).tipo;
        return (value == null) ? null : pt.ist.fenixframework.pstm.ToSqlConverter.getValueForString(value);
    }
    
    private final void set$tipo(java.lang.String arg0, pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State  obj$state) {
        ((DO_State)obj$state).tipo = (java.lang.String)((arg0 == null) ? null : arg0);
    }
    
    public java.lang.String getDescricao() {
        pt.ist.fenixframework.pstm.DataAccessPatterns.noteGetAccess(this, "descricao");
        return ((DO_State)this.get$obj$state(false)).descricao;
    }
    
    public void setDescricao(java.lang.String descricao) {
        ((DO_State)this.get$obj$state(true)).descricao = descricao;
    }
    
    private java.lang.String get$descricao() {
        java.lang.String value = ((DO_State)this.get$obj$state(false)).descricao;
        return (value == null) ? null : pt.ist.fenixframework.pstm.ToSqlConverter.getValueForString(value);
    }
    
    private final void set$descricao(java.lang.String arg0, pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State  obj$state) {
        ((DO_State)obj$state).descricao = (java.lang.String)((arg0 == null) ? null : arg0);
    }
    
    public pt.ist.rest.domain.Prato getPrato() {
        pt.ist.fenixframework.pstm.DataAccessPatterns.noteGetAccess(this, "prato");
        return ((DO_State)this.get$obj$state(false)).prato;
    }
    
    public void setPrato(pt.ist.rest.domain.Prato prato) {
        PratoContainsAlimentos.add((pt.ist.rest.domain.Alimento)this, prato);
    }
    
    public boolean hasPrato() {
        return (getPrato() != null);
    }
    
    public void removePrato() {
        setPrato(null);
    }
    
    private java.lang.Long get$oidPrato() {
        pt.ist.fenixframework.pstm.AbstractDomainObject value = ((DO_State)this.get$obj$state(false)).prato;
        return (value == null) ? null : value.getOid();
    }
    
    protected void checkDisconnected() {
        if (hasPrato()) handleAttemptToDeleteConnectedObject();
        
    }
    
    protected void readStateFromResultSet(java.sql.ResultSet rs, pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State  state) throws java.sql.SQLException {
        DO_State castedState = (DO_State)state;
        set$tipo(pt.ist.fenixframework.pstm.ResultSetReader.readString(rs, "TIPO"), state);
        set$descricao(pt.ist.fenixframework.pstm.ResultSetReader.readString(rs, "DESCRICAO"), state);
        castedState.prato = pt.ist.fenixframework.pstm.ResultSetReader.readDomainObject(rs, "OID_PRATO");
    }
    protected dml.runtime.Relation get$$relationFor(String attrName) {
        return super.get$$relationFor(attrName);
        
    }
    protected pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State  make$newState() {
        return new DO_State();
        
    }
    protected void create$allLists() {
        super.create$allLists();
        
    }
    protected static class DO_State extends pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State {
        private java.lang.String tipo;
        private java.lang.String descricao;
        private pt.ist.rest.domain.Prato prato;
        protected void copyTo(pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State  newState) {
            super.copyTo(newState);
            DO_State newCasted = (DO_State)newState;
            newCasted.tipo = this.tipo;
            newCasted.descricao = this.descricao;
            newCasted.prato = this.prato;
            
        }
        
        // serialization code
        protected Object writeReplace() throws java.io.ObjectStreamException {
            return new SerializedForm(this);
        }
        
        protected static class SerializedForm extends pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State.SerializedForm {
            private static final long serialVersionUID = 1L;
            
            private java.lang.String tipo;
            private java.lang.String descricao;
            private pt.ist.rest.domain.Prato prato;
            
            protected  SerializedForm(DO_State obj) {
                super(obj);
                this.tipo = obj.tipo;
                this.descricao = obj.descricao;
                this.prato = obj.prato;
                
            }
            
             Object readResolve() throws java.io.ObjectStreamException {
                DO_State newState = new DO_State();
                fillInState(newState);
                return newState;
            }
            
            protected void fillInState(pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State obj) {
                super.fillInState(obj);
                DO_State state = (DO_State)obj;
                state.tipo = this.tipo;
                state.descricao = this.descricao;
                state.prato = this.prato;
                
            }
            
        }
        
    }
    
}
