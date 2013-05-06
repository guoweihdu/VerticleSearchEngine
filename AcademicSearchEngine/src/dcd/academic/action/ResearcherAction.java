package dcd.academic.action;

import java.util.ArrayList;
import java.util.List;

import dcd.academic.model.PublicationModel;
import dcd.academic.model.ResearcherModel;
import dcd.academic.solrj.SolrjHelper;
import dcd.academic.model.TotalListMap;

import com.opensymphony.xwork2.ActionSupport;

public class ResearcherAction extends ActionSupport {
	
	private String name;
	private int start = 0;
	private int rows = 50;
	private long total;
	
	public ResearcherModel info = new ResearcherModel();
	public List<PublicationModel> paperlist = new ArrayList<PublicationModel>();

	@Override
	public String execute() throws Exception {
		
		SolrjHelper solr = new SolrjHelper(1);
		info = solr.getAuthorInfo(name);
		TotalListMap map = solr.getPaperMetaList("author", name, start, rows);
		total = map.getTotal()>rows ? rows : map.getTotal();
		paperlist = map.getList();

		return SUCCESS;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public ResearcherModel getInfo() {
		return info;
	}

	public void setInfo(ResearcherModel info) {
		this.info = info;
	}

	public List<PublicationModel> getPaperlist() {
		return paperlist;
	}

	public void setPaperlist(List<PublicationModel> paperlist) {
		this.paperlist = paperlist;
	}
	
}
