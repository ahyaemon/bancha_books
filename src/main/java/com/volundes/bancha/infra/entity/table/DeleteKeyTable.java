package com.volundes.bancha.infra.entity.table;

import org.seasar.doma.*;

@Entity
@Table(name = "delete_key")
public class DeleteKeyTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delete_key_id")
    public Long deleteKeyId;

    @Column(name = "comment_id")
    public Long commentId;

    @Column(name = "delete_key")
    public String deleteKey;

}
