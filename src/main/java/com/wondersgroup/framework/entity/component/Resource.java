package com.wondersgroup.framework.entity.component;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.wondersgroup.framework.entity.IdEntity;

/**
 * 系统资源组件
 */
@Entity
@Table(name = "Component_Resource")
public class Resource extends IdEntity {

	/** 描述. */
	private static final long serialVersionUID = -8890032394492600573L;

	/** 文件尺寸. */
	@Column(length = 32)
	private String fileSize;

	/** 文件名. */
	@Column(length = 128)
	private String fileName;

	/** 上传时间. */
	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date uploadTime;

	/** 上传文件数据. */
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name="File_Data",length = 10240, updatable = false)
	private byte[] file;

	/** 文件类型. */
	@Transient
	private String fileType;

	/**
	 * 上传文件存储方式<br>
	 * db,file.
	 */
	@Column(length = 16, updatable = false)
	@Enumerated(EnumType.STRING)
	private StoreType storeType = StoreType.FILE;

	/** 唯一id用作，下载标识。. */
	@Column(length = 32, unique = true, updatable = false)
	private String uuid;

	/**
	 * Gets the 文件尺寸.
	 * 
	 * @return the 文件尺寸
	 */
	public String getFileSize() {
		return fileSize;
	}

	/**
	 * Sets the 文件尺寸.
	 * 
	 * @param fileSize
	 *            the new 文件尺寸
	 */
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	/**
	 * Gets the 文件名.
	 * 
	 * @return the 文件名
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Sets the 文件名.
	 * 
	 * @param fileName
	 *            the new 文件名
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * Gets the 上传时间.
	 * 
	 * @return the 上传时间
	 */
	public Date getUploadTime() {
		return uploadTime;
	}

	/**
	 * Sets the 上传时间.
	 * 
	 * @param uploadTime
	 *            the new 上传时间
	 */
	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

	/**
	 * Gets the 上传文件数据.
	 * 
	 * @return the 上传文件数据
	 */
	public byte[] getFile() {
		return file;
	}

	/**
	 * Sets the 上传文件数据.
	 * 
	 * @param file
	 *            the new 上传文件数据
	 */
	public void setFile(byte[] file) {
		this.file = file;
	}

	/**
	 * Gets the file type.
	 * 
	 * @return the file type
	 */
	public String getFileType() {
		return fileType;
	}

	/**
	 * Sets the file type.
	 * 
	 * @param fileType
	 *            the new file type
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	/**
	 * Gets the 上传文件存储方式<br>
	 * db,file.
	 * 
	 * @return the 上传文件存储方式<br>
	 *         db,file
	 */
	public StoreType getStoreType() {
		return storeType;
	}

	/**
	 * Sets the 上传文件存储方式<br>
	 * db,file.
	 * 
	 * @param storeType
	 *            the new 上传文件存储方式<br>
	 *            db,file
	 */
	public void setStoreType(StoreType storeType) {
		this.storeType = storeType;
	}

	/**
	 * Gets the 唯一id用作，下载标识。.
	 * 
	 * @return the 唯一id用作，下载标识。
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * Sets the 唯一id用作，下载标识。.
	 * 
	 * @param uuid
	 *            the new 唯一id用作，下载标识。
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * 得到实际文件的存储名。 描述.
	 * 
	 * @return the real store name
	 */
	public String getRealStoreName() {
		if (getUuid() == null || getUuid().equals("")) {
			return null;
		}
		return getUuid() + "." + getFileType();
	}

	/**
	 * 得到不含后缀的文件名。 描述.
	 * 
	 * @return the only name
	 */
	public String getOnlyName() {
		if (getFileName() == null) {
			return null;
		}

		int endIndex = getFileName().lastIndexOf(".");
		if (endIndex == -1) {
			return null;
		}
		return getFileName().substring(0, endIndex);
	}
}
