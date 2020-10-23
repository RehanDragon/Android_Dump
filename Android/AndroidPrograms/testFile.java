   /* this is for  progress bar work*/
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    mProgressBar.setProgress(0);
                                }
                            }, 500);
                            Toast.makeText(MainActivity.this, "Upload successful", Toast.LENGTH_LONG).show();
                            /* this is for  progress bar work   ends here*/
							
							
							
							
							
				



				
							
		// mDatabaseRef
        mDatabaseRef=FirebaseDatabase.getInstance().getReference().child("Image");
        // mStorageRef
        mStorageRef=FirebaseStorage.getInstance().getReference().child("Images");
        mStorageRef.child("abc").putFile(mImageUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                task.getResult().getStorage().getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        
						

                        HashMap<String,Object> data=new HashMap<>();
                        String newUri=uri.toString();
                        data.put("myImage",newUri);
                        mDatabaseRef.setValue(data).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(MainActivity.this, "image Stored", Toast.LENGTH_SHORT).show();
                            }
                        });


                    }
                });
            }
        });		











//////////////////////////////////////////////////////////////////////////////	


 final StorageReference photoRef = mStorageRef.child(mImageUri.getLastPathSegment());

     photoRef.putFile(mImageUri)
             .addOnSuccessListener(this, new OnSuccessListener<UploadTask.TaskSnapshot>() {
                 @Override
                 public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                     
					 //from here it starts getting tricky
					 photoRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                         @Override
                         public void onSuccess(Uri uri) {
                             Uri dlUri = uri;
                             Upload friendlyMessage = new Upload(mEditTextFileName.getText().toString().trim(),dlUri.toString());
                             mDatabaseRef.push().setValue(friendlyMessage);
                         }
                     });
                 }
             });



			 
			 //mUploadTask 
			 
			 
			 
			 
			 
			 
			 
			 
	// [START upload_get_download_url]
        final StorageReference ref = storageRef.child("images/mountains.jpg");
        uploadTask = ref.putFile(file);

        Task<Uri> urlTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
            @Override
            public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                if (!task.isSuccessful()) {
                    throw task.getException();
                }

                // Continue with the task to get the download URL
                return ref.getDownloadUrl();
            }
        }).addOnCompleteListener(new OnCompleteListener<Uri>() {
            @Override
            public void onComplete(@NonNull Task<Uri> task) {
                if (task.isSuccessful()) {
                    Uri downloadUri = task.getResult();
                } else {
                    // Handle failures
                    // ...
                }
            }
        });
        // [END upload_get_download_url]		 
			 
			 
			 

	