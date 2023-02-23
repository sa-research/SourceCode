from Util import get_direct_files_from_folder

sonar_seed_path = ""
sonar_project_name = "Statfier"
sonar_project_key = ""

def main():
    seed_folder_paths = get_direct_files_from_folder(sonar_seed_path)
    for seed_folder_path in seed_folder_paths:
        contents = []
        contents.append("sonar.projectKey=" + sonar_project_name + "\nsonar.projectName=" + sonar_project_name + "\nsonar.projectVersion=1.0")
        contents.append("sonar.login=" + sonar_project_key)
        contents.append("sonar.sourceEncoding=UTF-8")
        contents.append("")

main()