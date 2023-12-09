package com.asm.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@NamedStoredProcedureQueries({
//		@NamedStoredProcedureQuery(name = "Report.favoriteByYear", procedureName = "spFavoriteByYear", parameters = {
//				@StoredProcedureParameter(name = "year", type = Integer.class) }, resultClasses = { Report.class }) })

@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name="Report.spFavoriteByYear", procedureName = "spFavoriteByYear", resultClasses = Report.class,
			parameters = @StoredProcedureParameter(type = Integer.class, name = "y")
			)

})

@NamedQueries({
	@NamedQuery(
			name = "Video.selectVidLike", 
			query = "select f.video, COUNT(f.id) from Favorite f"
	),

    
})



@Entity
public class Report implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	String group;
	long like;
	@Temporal(TemporalType.DATE)
	Date newest;
	@Temporal(TemporalType.DATE)
	Date oldest;

	public Report() {
		super();
	}

	public Report(String group, long like, Date newest, Date oldest) {
		super();
		this.group = group;
		this.like = like;
		this.newest = newest;
		this.oldest = oldest;
	}


	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public long getLike() {
		return like;
	}

	public void setLike(long like) {
		this.like = like;
	}

	public Date getNewest() {
		return newest;
	}

	public void setNewest(Date newest) {
		this.newest = newest;
	}

	public Date getOldest() {
		return oldest;
	}

	public void setOldest(Date oldest) {
		this.oldest = oldest;
	}

}
