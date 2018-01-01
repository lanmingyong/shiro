package org.lan.pojo;

import java.io.Serializable;

public class UploadItemInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -1056250617636192461L;
	/**
    form表单普通字段的名字
     */
    private String formFieldName;
    /**
     * form表单普通字段的值
     */
    private String formFieldValue;
    /**文件上传后保存的路径
     *
     */
    private String uploadSavePath;
    /**文件上传后保存的文件名
     *
     */
    private String uploadSaveFileName;
    /**文件的缓存路径
     *
     */
    private String tempPath;
    /**文件的原名
     *
     */
    private String fileName;

    /**
     * 文件的大小
     */
    private Long fileSize;
    
    public String getFormFieldName() {
        return formFieldName;
    }

    public void setFormFieldName(String formFieldName) {
        this.formFieldName = formFieldName;
    }

    public String getFormFieldValue() {
        return formFieldValue;
    }

    public void setFormFieldValue(String formFieldValue) {
        this.formFieldValue = formFieldValue;
    }

    public String getUploadSavePath() {
        return uploadSavePath;
    }

    public void setUploadSavePath(String uploadSavePath) {
        this.uploadSavePath = uploadSavePath;
    }

    public String getUploadSaveFileName() {
        return uploadSaveFileName;
    }

    public void setUploadSaveFileName(String uploadSaveFileName) {
        this.uploadSaveFileName = uploadSaveFileName;
    }

    public String getTempPath() {
        return tempPath;
    }

    public void setTempPath(String tempPath) {
        this.tempPath = tempPath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public String toString() {
        return "UploadItemInfo{" +
                "formFieldName='" + formFieldName + '\'' +
                ", formFieldValue='" + formFieldValue + '\'' +
                ", uploadSavePath='" + uploadSavePath + '\'' +
                ", uploadSaveFileName='" + uploadSaveFileName + '\'' +
                ", tempPath='" + tempPath + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileSize=" + fileSize +
                '}';
    }

	public UploadItemInfo(String formFieldName, String formFieldValue, String uploadSavePath, String uploadSaveFileName,
			String tempPath, String fileName, Long fileSize) {
		super();
		this.formFieldName = formFieldName;
		this.formFieldValue = formFieldValue;
		this.uploadSavePath = uploadSavePath;
		this.uploadSaveFileName = uploadSaveFileName;
		this.tempPath = tempPath;
		this.fileName = fileName;
		this.fileSize = fileSize;
	}
    
}
