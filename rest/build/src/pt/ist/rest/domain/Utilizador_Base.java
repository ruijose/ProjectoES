package pt.ist.rest.domain;

import pt.ist.fenixframework.pstm.VBox;
import pt.ist.fenixframework.pstm.RelationList;
import pt.ist.fenixframework.pstm.OJBFunctionalSetWrapper;
import pt.ist.fenixframework.ValueTypeSerializationGenerator.*;
public abstract class Utilizador_Base extends pt.ist.fenixframework.pstm.OneBoxDomainObject {
    public final static pt.ist.fenixframework.pstm.dml.RoleOne<pt.ist.rest.domain.Utilizador,pt.ist.rest.domain.Rest> role$$rest = new pt.ist.fenixframework.pstm.dml.RoleOne<pt.ist.rest.domain.Utilizador,pt.ist.rest.domain.Rest>() {
        public pt.ist.rest.domain.Rest getValue(pt.ist.rest.domain.Utilizador o1) {
            return ((Utilizador_Base.DO_State)o1.get$obj$state(false)).rest;
        }
        public void setValue(pt.ist.rest.domain.Utilizador o1, pt.ist.rest.domain.Rest o2) {
            ((Utilizador_Base.DO_State)o1.get$obj$state(true)).rest = o2;
        }
        public dml.runtime.Role<pt.ist.rest.domain.Rest,pt.ist.rest.domain.Utilizador> getInverseRole() {
            return pt.ist.rest.domain.Rest.role$$utilizador;
        }
        
    };
    public final static pt.ist.fenixframework.pstm.LoggingRelation<pt.ist.rest.domain.Utilizador,pt.ist.rest.domain.Rest> RestContainsUtilizadores = new pt.ist.fenixframework.pstm.LoggingRelation<pt.ist.rest.domain.Utilizador,pt.ist.rest.domain.Rest>(role$$rest);
    static {
        pt.ist.rest.domain.Rest.RestContainsUtilizadores = RestContainsUtilizadores.getInverseRelation();
    }
    
    static {
        RestContainsUtilizadores.setRelationName("pt.ist.rest.domain.Utilizador.RestContainsUtilizadores");
    }
    
    
    
    
    private void initInstance() {
        initInstance(true);
    }
    
    private void initInstance(boolean allocateOnly) {
        
    }
    
    {
        initInstance(false);
    }
    
    protected  Utilizador_Base() {
        super();
    }
    
    public java.lang.String getUsername() {
        pt.ist.fenixframework.pstm.DataAccessPatterns.noteGetAccess(this, "username");
        return ((DO_State)this.get$obj$state(false)).username;
    }
    
    public void setUsername(java.lang.String username) {
        ((DO_State)this.get$obj$state(true)).username = username;
    }
    
    private java.lang.String get$username() {
        java.lang.String value = ((DO_State)this.get$obj$state(false)).username;
        return (value == null) ? null : pt.ist.fenixframework.pstm.ToSqlConverter.getValueForString(value);
    }
    
    private final void set$username(java.lang.String arg0, pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State  obj$state) {
        ((DO_State)obj$state).username = (java.lang.String)((arg0 == null) ? null : arg0);
    }
    
    public java.lang.String getPassword() {
        pt.ist.fenixframework.pstm.DataAccessPatterns.noteGetAccess(this, "password");
        return ((DO_State)this.get$obj$state(false)).password;
    }
    
    public void setPassword(java.lang.String password) {
        ((DO_State)this.get$obj$state(true)).password = password;
    }
    
    private java.lang.String get$password() {
        java.lang.String value = ((DO_State)this.get$obj$state(false)).password;
        return (value == null) ? null : pt.ist.fenixframework.pstm.ToSqlConverter.getValueForString(value);
    }
    
    private final void set$password(java.lang.String arg0, pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State  obj$state) {
        ((DO_State)obj$state).password = (java.lang.String)((arg0 == null) ? null : arg0);
    }
    
    public pt.ist.rest.domain.Rest getRest() {
        pt.ist.fenixframework.pstm.DataAccessPatterns.noteGetAccess(this, "rest");
        return ((DO_State)this.get$obj$state(false)).rest;
    }
    
    public void setRest(pt.ist.rest.domain.Rest rest) {
        RestContainsUtilizadores.add((pt.ist.rest.domain.Utilizador)this, rest);
    }
    
    public boolean hasRest() {
        return (getRest() != null);
    }
    
    public void removeRest() {
        setRest(null);
    }
    
    private java.lang.Long get$oidRest() {
        pt.ist.fenixframework.pstm.AbstractDomainObject value = ((DO_State)this.get$obj$state(false)).rest;
        return (value == null) ? null : value.getOid();
    }
    
    protected void checkDisconnected() {
        if (hasRest()) handleAttemptToDeleteConnectedObject();
        
    }
    
    protected void readStateFromResultSet(java.sql.ResultSet rs, pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State  state) throws java.sql.SQLException {
        DO_State castedState = (DO_State)state;
        set$username(pt.ist.fenixframework.pstm.ResultSetReader.readString(rs, "USERNAME"), state);
        set$password(pt.ist.fenixframework.pstm.ResultSetReader.readString(rs, "PASSWORD"), state);
        castedState.rest = pt.ist.fenixframework.pstm.ResultSetReader.readDomainObject(rs, "OID_REST");
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
        private java.lang.String username;
        private java.lang.String password;
        private pt.ist.rest.domain.Rest rest;
        protected void copyTo(pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State  newState) {
            super.copyTo(newState);
            DO_State newCasted = (DO_State)newState;
            newCasted.username = this.username;
            newCasted.password = this.password;
            newCasted.rest = this.rest;
            
        }
        
        // serialization code
        protected Object writeReplace() throws java.io.ObjectStreamException {
            return new SerializedForm(this);
        }
        
        protected static class SerializedForm extends pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State.SerializedForm {
            private static final long serialVersionUID = 1L;
            
            private java.lang.String username;
            private java.lang.String password;
            private pt.ist.rest.domain.Rest rest;
            
            protected  SerializedForm(DO_State obj) {
                super(obj);
                this.username = obj.username;
                this.password = obj.password;
                this.rest = obj.rest;
                
            }
            
             Object readResolve() throws java.io.ObjectStreamException {
                DO_State newState = new DO_State();
                fillInState(newState);
                return newState;
            }
            
            protected void fillInState(pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State obj) {
                super.fillInState(obj);
                DO_State state = (DO_State)obj;
                state.username = this.username;
                state.password = this.password;
                state.rest = this.rest;
                
            }
            
        }
        
    }
    
}
