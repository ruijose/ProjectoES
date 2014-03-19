package pt.ist.rest.domain;

import pt.ist.fenixframework.pstm.VBox;
import pt.ist.fenixframework.pstm.RelationList;
import pt.ist.fenixframework.pstm.OJBFunctionalSetWrapper;
import pt.ist.fenixframework.ValueTypeSerializationGenerator.*;
public abstract class Prato_Base extends pt.ist.fenixframework.pstm.OneBoxDomainObject {
    public final static dml.runtime.RoleMany<pt.ist.rest.domain.Prato,pt.ist.rest.domain.Cliente> role$$cliente = new dml.runtime.RoleMany<pt.ist.rest.domain.Prato,pt.ist.rest.domain.Cliente>() {
        public dml.runtime.RelationBaseSet<pt.ist.rest.domain.Cliente> getSet(pt.ist.rest.domain.Prato o1) {
            return ((Prato_Base)o1).get$rl$cliente();
        }
        public dml.runtime.Role<pt.ist.rest.domain.Cliente,pt.ist.rest.domain.Prato> getInverseRole() {
            return pt.ist.rest.domain.Cliente.role$$prato;
        }
        
    };
    public final static pt.ist.fenixframework.pstm.dml.RoleOne<pt.ist.rest.domain.Prato,pt.ist.rest.domain.Restaurante> role$$restaurante = new pt.ist.fenixframework.pstm.dml.RoleOne<pt.ist.rest.domain.Prato,pt.ist.rest.domain.Restaurante>() {
        public pt.ist.rest.domain.Restaurante getValue(pt.ist.rest.domain.Prato o1) {
            return ((Prato_Base.DO_State)o1.get$obj$state(false)).restaurante;
        }
        public void setValue(pt.ist.rest.domain.Prato o1, pt.ist.rest.domain.Restaurante o2) {
            ((Prato_Base.DO_State)o1.get$obj$state(true)).restaurante = o2;
        }
        public dml.runtime.Role<pt.ist.rest.domain.Restaurante,pt.ist.rest.domain.Prato> getInverseRole() {
            return pt.ist.rest.domain.Restaurante.role$$prato;
        }
        
    };
    public final static dml.runtime.RoleMany<pt.ist.rest.domain.Prato,pt.ist.rest.domain.Item> role$$item = new dml.runtime.RoleMany<pt.ist.rest.domain.Prato,pt.ist.rest.domain.Item>() {
        public dml.runtime.RelationBaseSet<pt.ist.rest.domain.Item> getSet(pt.ist.rest.domain.Prato o1) {
            return ((Prato_Base)o1).get$rl$item();
        }
        public dml.runtime.Role<pt.ist.rest.domain.Item,pt.ist.rest.domain.Prato> getInverseRole() {
            return pt.ist.rest.domain.Item.role$$prato;
        }
        
    };
    public final static dml.runtime.RoleMany<pt.ist.rest.domain.Prato,pt.ist.rest.domain.Alimento> role$$alimento = new dml.runtime.RoleMany<pt.ist.rest.domain.Prato,pt.ist.rest.domain.Alimento>() {
        public dml.runtime.RelationBaseSet<pt.ist.rest.domain.Alimento> getSet(pt.ist.rest.domain.Prato o1) {
            return ((Prato_Base)o1).get$rl$alimento();
        }
        public dml.runtime.Role<pt.ist.rest.domain.Alimento,pt.ist.rest.domain.Prato> getInverseRole() {
            return pt.ist.rest.domain.Alimento.role$$prato;
        }
        
    };
    public final static pt.ist.fenixframework.pstm.LoggingRelation<pt.ist.rest.domain.Prato,pt.ist.rest.domain.Cliente> ClienteContainsPratos = new pt.ist.fenixframework.pstm.LoggingRelation<pt.ist.rest.domain.Prato,pt.ist.rest.domain.Cliente>(role$$cliente);
    static {
        pt.ist.rest.domain.Cliente.ClienteContainsPratos = ClienteContainsPratos.getInverseRelation();
    }
    
    static {
        ClienteContainsPratos.setRelationName("pt.ist.rest.domain.Prato.ClienteContainsPratos");
        ClienteContainsPratos.addListener(new dml.runtime.RelationAdapter<pt.ist.rest.domain.Prato,pt.ist.rest.domain.Cliente>() {
            @Override
            public void beforeAdd(pt.ist.rest.domain.Prato arg0, pt.ist.rest.domain.Cliente arg1) {
                pt.ist.fenixframework.pstm.Transaction.addRelationTuple("ClienteContainsPratos", arg1, "prato", arg0, "cliente");
            }
            @Override
            public void beforeRemove(pt.ist.rest.domain.Prato arg0, pt.ist.rest.domain.Cliente arg1) {
                pt.ist.fenixframework.pstm.Transaction.removeRelationTuple("ClienteContainsPratos", arg1, "prato", arg0, "cliente");
            }
            
        }
        );
    }
    public final static pt.ist.fenixframework.pstm.LoggingRelation<pt.ist.rest.domain.Prato,pt.ist.rest.domain.Restaurante> RestauranteContainsPratos = new pt.ist.fenixframework.pstm.LoggingRelation<pt.ist.rest.domain.Prato,pt.ist.rest.domain.Restaurante>(role$$restaurante);
    static {
        pt.ist.rest.domain.Restaurante.RestauranteContainsPratos = RestauranteContainsPratos.getInverseRelation();
    }
    
    static {
        RestauranteContainsPratos.setRelationName("pt.ist.rest.domain.Prato.RestauranteContainsPratos");
    }
    public final static pt.ist.fenixframework.pstm.LoggingRelation<pt.ist.rest.domain.Prato,pt.ist.rest.domain.Item> ItemContainsPratos = new pt.ist.fenixframework.pstm.LoggingRelation<pt.ist.rest.domain.Prato,pt.ist.rest.domain.Item>(role$$item);
    static {
        pt.ist.rest.domain.Item.ItemContainsPratos = ItemContainsPratos.getInverseRelation();
    }
    
    static {
        ItemContainsPratos.setRelationName("pt.ist.rest.domain.Prato.ItemContainsPratos");
    }
    public static dml.runtime.Relation<pt.ist.rest.domain.Prato,pt.ist.rest.domain.Alimento> PratoContainsAlimentos;
    
    
    private RelationList<pt.ist.rest.domain.Prato,pt.ist.rest.domain.Cliente> get$rl$cliente() {
        return get$$relationList("cliente", ClienteContainsPratos);
        
    }
    private RelationList<pt.ist.rest.domain.Prato,pt.ist.rest.domain.Item> get$rl$item() {
        return get$$relationList("item", ItemContainsPratos);
        
    }
    private RelationList<pt.ist.rest.domain.Prato,pt.ist.rest.domain.Alimento> get$rl$alimento() {
        return get$$relationList("alimento", PratoContainsAlimentos);
        
    }
    
    
    private void initInstance() {
        initInstance(true);
    }
    
    private void initInstance(boolean allocateOnly) {
        
    }
    
    {
        initInstance(false);
    }
    
    protected  Prato_Base() {
        super();
    }
    
    public java.lang.String getNome() {
        pt.ist.fenixframework.pstm.DataAccessPatterns.noteGetAccess(this, "nome");
        return ((DO_State)this.get$obj$state(false)).nome;
    }
    
    public void setNome(java.lang.String nome) {
        ((DO_State)this.get$obj$state(true)).nome = nome;
    }
    
    private java.lang.String get$nome() {
        java.lang.String value = ((DO_State)this.get$obj$state(false)).nome;
        return (value == null) ? null : pt.ist.fenixframework.pstm.ToSqlConverter.getValueForString(value);
    }
    
    private final void set$nome(java.lang.String arg0, pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State  obj$state) {
        ((DO_State)obj$state).nome = (java.lang.String)((arg0 == null) ? null : arg0);
    }
    
    public java.lang.Integer getPreco() {
        pt.ist.fenixframework.pstm.DataAccessPatterns.noteGetAccess(this, "preco");
        return ((DO_State)this.get$obj$state(false)).preco;
    }
    
    public void setPreco(java.lang.Integer preco) {
        ((DO_State)this.get$obj$state(true)).preco = preco;
    }
    
    private java.lang.Integer get$preco() {
        java.lang.Integer value = ((DO_State)this.get$obj$state(false)).preco;
        return (value == null) ? null : pt.ist.fenixframework.pstm.ToSqlConverter.getValueForInteger(value);
    }
    
    private final void set$preco(java.lang.Integer arg0, pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State  obj$state) {
        ((DO_State)obj$state).preco = (java.lang.Integer)((arg0 == null) ? null : arg0);
    }
    
    public java.lang.Integer getCalorias() {
        pt.ist.fenixframework.pstm.DataAccessPatterns.noteGetAccess(this, "calorias");
        return ((DO_State)this.get$obj$state(false)).calorias;
    }
    
    public void setCalorias(java.lang.Integer calorias) {
        ((DO_State)this.get$obj$state(true)).calorias = calorias;
    }
    
    private java.lang.Integer get$calorias() {
        java.lang.Integer value = ((DO_State)this.get$obj$state(false)).calorias;
        return (value == null) ? null : pt.ist.fenixframework.pstm.ToSqlConverter.getValueForInteger(value);
    }
    
    private final void set$calorias(java.lang.Integer arg0, pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State  obj$state) {
        ((DO_State)obj$state).calorias = (java.lang.Integer)((arg0 == null) ? null : arg0);
    }
    
    public java.lang.Integer getIDPrato() {
        pt.ist.fenixframework.pstm.DataAccessPatterns.noteGetAccess(this, "IDPrato");
        return ((DO_State)this.get$obj$state(false)).IDPrato;
    }
    
    public void setIDPrato(java.lang.Integer IDPrato) {
        ((DO_State)this.get$obj$state(true)).IDPrato = IDPrato;
    }
    
    private java.lang.Integer get$IDPrato() {
        java.lang.Integer value = ((DO_State)this.get$obj$state(false)).IDPrato;
        return (value == null) ? null : pt.ist.fenixframework.pstm.ToSqlConverter.getValueForInteger(value);
    }
    
    private final void set$IDPrato(java.lang.Integer arg0, pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State  obj$state) {
        ((DO_State)obj$state).IDPrato = (java.lang.Integer)((arg0 == null) ? null : arg0);
    }
    
    public int getClienteCount() {
        return get$rl$cliente().size();
    }
    
    public boolean hasAnyCliente() {
        return (! get$rl$cliente().isEmpty());
    }
    
    public boolean hasCliente(pt.ist.rest.domain.Cliente cliente) {
        return get$rl$cliente().contains(cliente);
    }
    
    public java.util.Set<pt.ist.rest.domain.Cliente> getClienteSet() {
        return get$rl$cliente();
    }
    
    public void addCliente(pt.ist.rest.domain.Cliente cliente) {
        ClienteContainsPratos.add((pt.ist.rest.domain.Prato)this, cliente);
    }
    
    public void removeCliente(pt.ist.rest.domain.Cliente cliente) {
        ClienteContainsPratos.remove((pt.ist.rest.domain.Prato)this, cliente);
    }
    
    public java.util.List<pt.ist.rest.domain.Cliente> getCliente() {
        return get$rl$cliente();
    }
    
    public void set$cliente(OJBFunctionalSetWrapper cliente) {
        get$rl$cliente().setFromOJB(this, "cliente", cliente);
    }
    
    public java.util.Iterator<pt.ist.rest.domain.Cliente> getClienteIterator() {
        return get$rl$cliente().iterator();
    }
    
    public pt.ist.rest.domain.Restaurante getRestaurante() {
        pt.ist.fenixframework.pstm.DataAccessPatterns.noteGetAccess(this, "restaurante");
        return ((DO_State)this.get$obj$state(false)).restaurante;
    }
    
    public void setRestaurante(pt.ist.rest.domain.Restaurante restaurante) {
        RestauranteContainsPratos.add((pt.ist.rest.domain.Prato)this, restaurante);
    }
    
    public boolean hasRestaurante() {
        return (getRestaurante() != null);
    }
    
    public void removeRestaurante() {
        setRestaurante(null);
    }
    
    private java.lang.Long get$oidRestaurante() {
        pt.ist.fenixframework.pstm.AbstractDomainObject value = ((DO_State)this.get$obj$state(false)).restaurante;
        return (value == null) ? null : value.getOid();
    }
    
    public int getItemCount() {
        return get$rl$item().size();
    }
    
    public boolean hasAnyItem() {
        return (! get$rl$item().isEmpty());
    }
    
    public boolean hasItem(pt.ist.rest.domain.Item item) {
        return get$rl$item().contains(item);
    }
    
    public java.util.Set<pt.ist.rest.domain.Item> getItemSet() {
        return get$rl$item();
    }
    
    public void addItem(pt.ist.rest.domain.Item item) {
        ItemContainsPratos.add((pt.ist.rest.domain.Prato)this, item);
    }
    
    public void removeItem(pt.ist.rest.domain.Item item) {
        ItemContainsPratos.remove((pt.ist.rest.domain.Prato)this, item);
    }
    
    public java.util.List<pt.ist.rest.domain.Item> getItem() {
        return get$rl$item();
    }
    
    public void set$item(OJBFunctionalSetWrapper item) {
        get$rl$item().setFromOJB(this, "item", item);
    }
    
    public java.util.Iterator<pt.ist.rest.domain.Item> getItemIterator() {
        return get$rl$item().iterator();
    }
    
    public int getAlimentoCount() {
        return get$rl$alimento().size();
    }
    
    public boolean hasAnyAlimento() {
        return (! get$rl$alimento().isEmpty());
    }
    
    public boolean hasAlimento(pt.ist.rest.domain.Alimento alimento) {
        return get$rl$alimento().contains(alimento);
    }
    
    public java.util.Set<pt.ist.rest.domain.Alimento> getAlimentoSet() {
        return get$rl$alimento();
    }
    
    public void addAlimento(pt.ist.rest.domain.Alimento alimento) {
        PratoContainsAlimentos.add((pt.ist.rest.domain.Prato)this, alimento);
    }
    
    public void removeAlimento(pt.ist.rest.domain.Alimento alimento) {
        PratoContainsAlimentos.remove((pt.ist.rest.domain.Prato)this, alimento);
    }
    
    public java.util.List<pt.ist.rest.domain.Alimento> getAlimento() {
        return get$rl$alimento();
    }
    
    public void set$alimento(OJBFunctionalSetWrapper alimento) {
        get$rl$alimento().setFromOJB(this, "alimento", alimento);
    }
    
    public java.util.Iterator<pt.ist.rest.domain.Alimento> getAlimentoIterator() {
        return get$rl$alimento().iterator();
    }
    
    protected void checkDisconnected() {
        if (hasAnyCliente()) handleAttemptToDeleteConnectedObject();
        if (hasRestaurante()) handleAttemptToDeleteConnectedObject();
        if (hasAnyItem()) handleAttemptToDeleteConnectedObject();
        if (hasAnyAlimento()) handleAttemptToDeleteConnectedObject();
        
    }
    
    protected void readStateFromResultSet(java.sql.ResultSet rs, pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State  state) throws java.sql.SQLException {
        DO_State castedState = (DO_State)state;
        set$nome(pt.ist.fenixframework.pstm.ResultSetReader.readString(rs, "NOME"), state);
        set$preco(pt.ist.fenixframework.pstm.ResultSetReader.readInteger(rs, "PRECO"), state);
        set$calorias(pt.ist.fenixframework.pstm.ResultSetReader.readInteger(rs, "CALORIAS"), state);
        set$IDPrato(pt.ist.fenixframework.pstm.ResultSetReader.readInteger(rs, "I_D_PRATO"), state);
        castedState.restaurante = pt.ist.fenixframework.pstm.ResultSetReader.readDomainObject(rs, "OID_RESTAURANTE");
    }
    protected dml.runtime.Relation get$$relationFor(String attrName) {
        if (attrName.equals("cliente")) return ClienteContainsPratos;
        if (attrName.equals("item")) return ItemContainsPratos;
        if (attrName.equals("alimento")) return PratoContainsAlimentos;
        return super.get$$relationFor(attrName);
        
    }
    protected pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State  make$newState() {
        return new DO_State();
        
    }
    protected void create$allLists() {
        super.create$allLists();
        get$$relationList("cliente", ClienteContainsPratos);
        get$$relationList("item", ItemContainsPratos);
        get$$relationList("alimento", PratoContainsAlimentos);
        
    }
    protected static class DO_State extends pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State {
        private java.lang.String nome;
        private java.lang.Integer preco;
        private java.lang.Integer calorias;
        private java.lang.Integer IDPrato;
        private pt.ist.rest.domain.Restaurante restaurante;
        protected void copyTo(pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State  newState) {
            super.copyTo(newState);
            DO_State newCasted = (DO_State)newState;
            newCasted.nome = this.nome;
            newCasted.preco = this.preco;
            newCasted.calorias = this.calorias;
            newCasted.IDPrato = this.IDPrato;
            newCasted.restaurante = this.restaurante;
            
        }
        
        // serialization code
        protected Object writeReplace() throws java.io.ObjectStreamException {
            return new SerializedForm(this);
        }
        
        protected static class SerializedForm extends pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State.SerializedForm {
            private static final long serialVersionUID = 1L;
            
            private java.lang.String nome;
            private java.lang.Integer preco;
            private java.lang.Integer calorias;
            private java.lang.Integer IDPrato;
            private pt.ist.rest.domain.Restaurante restaurante;
            
            protected  SerializedForm(DO_State obj) {
                super(obj);
                this.nome = obj.nome;
                this.preco = obj.preco;
                this.calorias = obj.calorias;
                this.IDPrato = obj.IDPrato;
                this.restaurante = obj.restaurante;
                
            }
            
             Object readResolve() throws java.io.ObjectStreamException {
                DO_State newState = new DO_State();
                fillInState(newState);
                return newState;
            }
            
            protected void fillInState(pt.ist.fenixframework.pstm.OneBoxDomainObject.DO_State obj) {
                super.fillInState(obj);
                DO_State state = (DO_State)obj;
                state.nome = this.nome;
                state.preco = this.preco;
                state.calorias = this.calorias;
                state.IDPrato = this.IDPrato;
                state.restaurante = this.restaurante;
                
            }
            
        }
        
    }
    
}
