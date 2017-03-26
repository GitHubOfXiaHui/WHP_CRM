package com.whp.framework.utils;

public class PageModel {

	    //总条数
		private int numRecord;
		//每页显示条数
		private int pageSize;
		//总页数
		private int pageCount;
		//当前页数
		private int pageNum;
		//开始页数
		private int startRecord;
		//最后页数
		private int endRecord;
		
		public PageModel(int numRecord,int pageSize,int pageNum){
			this.setNumRecord(numRecord);
			this.setPageSize(pageSize);
			this.setPageCount();
			this.setPageNum(pageNum);
			this.setStartRecord();
			this.setEndRecord();
		}
		
		
		public int getNumRecord() {
			return numRecord;
		}


		public void setNumRecord(int numRecord) {
			this.numRecord = numRecord;
		}


		public int getPageSize() {
			return pageSize;
		}


		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}


		public int getPageCount() {
			return pageCount;
		}


		public void setPageCount() {
			this.pageCount =(numRecord + pageSize - 1)/pageSize;
		}


		public int getPageNum() {
			return pageNum;
		}


		public void setPageNum(int pageNum) {
			this.pageNum = pageNum;
			if (pageNum <= 0) {
				this.pageNum = 1;
			}else if (pageNum >= pageCount) {
				this.pageNum = this.pageCount;
			}
			
		}
		public int getStartRecord() {
			return startRecord;
		}
		public void setStartRecord() {
			this.startRecord =(this.pageNum-1)*this.pageSize;
		}
		public int getEndRecord() {
			return endRecord;
		}
		public void setEndRecord() {
			this.endRecord = this.pageNum*this.pageSize+1;
		}
		
	}

